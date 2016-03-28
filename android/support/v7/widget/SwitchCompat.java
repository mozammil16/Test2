package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0093R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class SwitchCompat extends CompoundButton {
    private static final int[] CHECKED_STATE_SET;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    private Animation mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private float mThumbPosition;
    private int mThumbTextPadding;
    private int mThumbWidth;
    private final TintManager mTintManager;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v7.widget.SwitchCompat.1 */
    class C01271 extends Animation {
        final /* synthetic */ float val$diff;
        final /* synthetic */ float val$startPosition;

        C01271(float f, float f2) {
            this.val$startPosition = f;
            this.val$diff = f2;
        }

        protected void applyTransformation(float interpolatedTime, Transformation t) {
            SwitchCompat.this.setThumbPosition(this.val$startPosition + (this.val$diff * interpolatedTime));
        }
    }

    static {
        int[] iArr = new int[TOUCH_MODE_DOWN];
        iArr[0] = 16842912;
        CHECKED_STATE_SET = iArr;
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attrs) {
        this(context, attrs, C0093R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mTextPaint = new TextPaint(TOUCH_MODE_DOWN);
        Resources res = getResources();
        this.mTextPaint.density = res.getDisplayMetrics().density;
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, C0093R.styleable.SwitchCompat, defStyleAttr, 0);
        this.mThumbDrawable = a.getDrawable(C0093R.styleable.SwitchCompat_android_thumb);
        this.mTrackDrawable = a.getDrawable(C0093R.styleable.SwitchCompat_track);
        this.mTextOn = a.getText(C0093R.styleable.SwitchCompat_android_textOn);
        this.mTextOff = a.getText(C0093R.styleable.SwitchCompat_android_textOff);
        this.mShowText = a.getBoolean(C0093R.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = a.getDimensionPixelSize(C0093R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = a.getDimensionPixelSize(C0093R.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = a.getDimensionPixelSize(C0093R.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = a.getBoolean(C0093R.styleable.SwitchCompat_splitTrack, false);
        int appearance = a.getResourceId(C0093R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (appearance != 0) {
            setSwitchTextAppearance(context, appearance);
        }
        this.mTintManager = a.getTintManager();
        a.recycle();
        ViewConfiguration config = ViewConfiguration.get(context);
        this.mTouchSlop = config.getScaledTouchSlop();
        this.mMinFlingVelocity = config.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(Context context, int resid) {
        TypedArray appearance = context.obtainStyledAttributes(resid, C0093R.styleable.SwitchCompatTextAppearance);
        ColorStateList colors = appearance.getColorStateList(C0093R.styleable.SwitchCompatTextAppearance_android_textColor);
        if (colors != null) {
            this.mTextColors = colors;
        } else {
            this.mTextColors = getTextColors();
        }
        int ts = appearance.getDimensionPixelSize(C0093R.styleable.SwitchCompatTextAppearance_android_textSize, 0);
        if (!(ts == 0 || ((float) ts) == this.mTextPaint.getTextSize())) {
            this.mTextPaint.setTextSize((float) ts);
            requestLayout();
        }
        if (appearance.getBoolean(C0093R.styleable.SwitchCompatTextAppearance_textAllCaps, false)) {
            this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
        } else {
            this.mSwitchTransformationMethod = null;
        }
        appearance.recycle();
    }

    public void setSwitchTypeface(Typeface tf, int style) {
        boolean z = false;
        if (style > 0) {
            int typefaceStyle;
            float f;
            if (tf == null) {
                tf = Typeface.defaultFromStyle(style);
            } else {
                tf = Typeface.create(tf, style);
            }
            setSwitchTypeface(tf);
            if (tf != null) {
                typefaceStyle = tf.getStyle();
            } else {
                typefaceStyle = 0;
            }
            int need = style & (typefaceStyle ^ -1);
            TextPaint textPaint = this.mTextPaint;
            if ((need & TOUCH_MODE_DOWN) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            textPaint = this.mTextPaint;
            if ((need & TOUCH_MODE_DRAGGING) != 0) {
                f = -0.25f;
            } else {
                f = 0.0f;
            }
            textPaint.setTextSkewX(f);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(tf);
    }

    public void setSwitchTypeface(Typeface tf) {
        if (this.mTextPaint.getTypeface() != tf) {
            this.mTextPaint.setTypeface(tf);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int pixels) {
        this.mSwitchPadding = pixels;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public void setSwitchMinWidth(int pixels) {
        this.mSwitchMinWidth = pixels;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public void setThumbTextPadding(int pixels) {
        this.mThumbTextPadding = pixels;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public void setTrackDrawable(Drawable track) {
        this.mTrackDrawable = track;
        requestLayout();
    }

    public void setTrackResource(int resId) {
        setTrackDrawable(this.mTintManager.getDrawable(resId));
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public void setThumbDrawable(Drawable thumb) {
        this.mThumbDrawable = thumb;
        requestLayout();
    }

    public void setThumbResource(int resId) {
        setThumbDrawable(this.mTintManager.getDrawable(resId));
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public void setSplitTrack(boolean splitTrack) {
        this.mSplitTrack = splitTrack;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public void setTextOn(CharSequence textOn) {
        this.mTextOn = textOn;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public void setTextOff(CharSequence textOff) {
        this.mTextOff = textOff;
        requestLayout();
    }

    public void setShowText(boolean showText) {
        if (this.mShowText != showText) {
            this.mShowText = showText;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int thumbWidth;
        int thumbHeight;
        int maxTextWidth;
        int trackHeight;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOn);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOff);
            }
        }
        Rect padding = this.mTempRect;
        if (this.mThumbDrawable != null) {
            this.mThumbDrawable.getPadding(padding);
            thumbWidth = (this.mThumbDrawable.getIntrinsicWidth() - padding.left) - padding.right;
            thumbHeight = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            thumbWidth = 0;
            thumbHeight = 0;
        }
        if (this.mShowText) {
            maxTextWidth = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * TOUCH_MODE_DRAGGING);
        } else {
            maxTextWidth = 0;
        }
        this.mThumbWidth = Math.max(maxTextWidth, thumbWidth);
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.getPadding(padding);
            trackHeight = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            padding.setEmpty();
            trackHeight = 0;
        }
        int paddingLeft = padding.left;
        int switchWidth = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * TOUCH_MODE_DRAGGING) + paddingLeft) + padding.right);
        int switchHeight = Math.max(trackHeight, thumbHeight);
        this.mSwitchWidth = switchWidth;
        this.mSwitchHeight = switchHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredHeight() < switchHeight) {
            setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), switchHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        CharSequence text = isChecked() ? this.mTextOn : this.mTextOff;
        if (text != null) {
            event.getText().add(text);
        }
    }

    private Layout makeLayout(CharSequence text) {
        CharSequence transformed;
        if (this.mSwitchTransformationMethod != null) {
            transformed = this.mSwitchTransformationMethod.getTransformation(text, this);
        } else {
            transformed = text;
        }
        return new StaticLayout(transformed, this.mTextPaint, (int) Math.ceil((double) Layout.getDesiredWidth(transformed, this.mTextPaint)), Alignment.ALIGN_NORMAL, TextTrackStyle.DEFAULT_FONT_SCALE, 0.0f, true);
    }

    private boolean hitThumb(float x, float y) {
        int thumbOffset = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int thumbLeft = (this.mSwitchLeft + thumbOffset) - this.mTouchSlop;
        return x > ((float) thumbLeft) && x < ((float) ((((this.mThumbWidth + thumbLeft) + this.mTempRect.left) + this.mTempRect.right) + this.mTouchSlop)) && y > ((float) (this.mSwitchTop - this.mTouchSlop)) && y < ((float) (this.mSwitchBottom + this.mTouchSlop));
    }

    public boolean onTouchEvent(MotionEvent ev) {
        this.mVelocityTracker.addMovement(ev);
        float x;
        float y;
        switch (MotionEventCompat.getActionMasked(ev)) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                x = ev.getX();
                y = ev.getY();
                if (isEnabled() && hitThumb(x, y)) {
                    this.mTouchMode = TOUCH_MODE_DOWN;
                    this.mTouchX = x;
                    this.mTouchY = y;
                    break;
                }
            case TOUCH_MODE_DOWN /*1*/:
            case MONOSPACE /*3*/:
                if (this.mTouchMode != TOUCH_MODE_DRAGGING) {
                    this.mTouchMode = 0;
                    this.mVelocityTracker.clear();
                    break;
                }
                stopDrag(ev);
                super.onTouchEvent(ev);
                return true;
            case TOUCH_MODE_DRAGGING /*2*/:
                switch (this.mTouchMode) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case TOUCH_MODE_DOWN /*1*/:
                        x = ev.getX();
                        y = ev.getY();
                        if (Math.abs(x - this.mTouchX) > ((float) this.mTouchSlop) || Math.abs(y - this.mTouchY) > ((float) this.mTouchSlop)) {
                            this.mTouchMode = TOUCH_MODE_DRAGGING;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.mTouchX = x;
                            this.mTouchY = y;
                            return true;
                        }
                    case TOUCH_MODE_DRAGGING /*2*/:
                        float dPos;
                        x = ev.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float thumbScrollOffset = x - this.mTouchX;
                        if (thumbScrollRange != 0) {
                            dPos = thumbScrollOffset / ((float) thumbScrollRange);
                        } else {
                            dPos = thumbScrollOffset > 0.0f ? TextTrackStyle.DEFAULT_FONT_SCALE : GroundOverlayOptions.NO_DIMENSION;
                        }
                        if (ViewUtils.isLayoutRtl(this)) {
                            dPos = -dPos;
                        }
                        float newPos = constrain(this.mThumbPosition + dPos, 0.0f, TextTrackStyle.DEFAULT_FONT_SCALE);
                        if (newPos != this.mThumbPosition) {
                            this.mTouchX = x;
                            setThumbPosition(newPos);
                        }
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    private void cancelSuperTouch(MotionEvent ev) {
        MotionEvent cancel = MotionEvent.obtain(ev);
        cancel.setAction(MONOSPACE);
        super.onTouchEvent(cancel);
        cancel.recycle();
    }

    private void stopDrag(MotionEvent ev) {
        boolean commitChange;
        boolean newState;
        this.mTouchMode = 0;
        if (ev.getAction() == TOUCH_MODE_DOWN && isEnabled()) {
            commitChange = true;
        } else {
            commitChange = false;
        }
        boolean oldState = isChecked();
        if (commitChange) {
            this.mVelocityTracker.computeCurrentVelocity(GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE);
            float xvel = this.mVelocityTracker.getXVelocity();
            newState = Math.abs(xvel) > ((float) this.mMinFlingVelocity) ? ViewUtils.isLayoutRtl(this) ? xvel < 0.0f : xvel > 0.0f : getTargetCheckedState();
        } else {
            newState = oldState;
        }
        if (newState != oldState) {
            playSoundEffect(0);
            setChecked(newState);
        }
        cancelSuperTouch(ev);
    }

    private void animateThumbToCheckedState(boolean newCheckedState) {
        float startPosition = this.mThumbPosition;
        this.mPositionAnimator = new C01271(startPosition, (newCheckedState ? TextTrackStyle.DEFAULT_FONT_SCALE : 0.0f) - startPosition);
        this.mPositionAnimator.setDuration(250);
        startAnimation(this.mPositionAnimator);
    }

    private void cancelPositionAnimator() {
        if (this.mPositionAnimator != null) {
            clearAnimation();
            this.mPositionAnimator = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    private void setThumbPosition(float position) {
        this.mThumbPosition = position;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean checked) {
        super.setChecked(checked);
        checked = isChecked();
        if (getWindowToken() != null) {
            animateThumbToCheckedState(checked);
            return;
        }
        cancelPositionAnimator();
        setThumbPosition(checked ? TextTrackStyle.DEFAULT_FONT_SCALE : 0.0f);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int switchLeft;
        int switchRight;
        int switchTop;
        int switchBottom;
        super.onLayout(changed, left, top, right, bottom);
        if (this.mThumbDrawable != null) {
            Rect trackPadding = this.mTempRect;
            if (this.mTrackDrawable != null) {
                this.mTrackDrawable.getPadding(trackPadding);
            } else {
                trackPadding.setEmpty();
            }
        }
        if (ViewUtils.isLayoutRtl(this)) {
            switchLeft = getPaddingLeft() + 0;
            switchRight = ((this.mSwitchWidth + switchLeft) + 0) + 0;
        } else {
            switchRight = (getWidth() - getPaddingRight()) + 0;
            switchLeft = ((switchRight - this.mSwitchWidth) + 0) + 0;
        }
        switch (getGravity() & 112) {
            case Place.TYPE_CAMPGROUND /*16*/:
                switchTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / TOUCH_MODE_DRAGGING) - (this.mSwitchHeight / TOUCH_MODE_DRAGGING);
                switchBottom = switchTop + this.mSwitchHeight;
                break;
            case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                switchBottom = getHeight() - getPaddingBottom();
                switchTop = switchBottom - this.mSwitchHeight;
                break;
            default:
                switchTop = getPaddingTop();
                switchBottom = switchTop + this.mSwitchHeight;
                break;
        }
        this.mSwitchLeft = switchLeft;
        this.mSwitchTop = switchTop;
        this.mSwitchBottom = switchBottom;
        this.mSwitchRight = switchRight;
    }

    public void draw(Canvas c) {
        Rect padding = this.mTempRect;
        int switchLeft = this.mSwitchLeft;
        int switchTop = this.mSwitchTop;
        int switchRight = this.mSwitchRight;
        int switchBottom = this.mSwitchBottom;
        int thumbInitialLeft = switchLeft + getThumbOffset();
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.getPadding(padding);
            thumbInitialLeft += padding.left;
            this.mTrackDrawable.setBounds(switchLeft, switchTop, switchRight, switchBottom);
        }
        if (this.mThumbDrawable != null) {
            this.mThumbDrawable.getPadding(padding);
            int thumbLeft = thumbInitialLeft - padding.left;
            int thumbRight = (this.mThumbWidth + thumbInitialLeft) + padding.right;
            this.mThumbDrawable.setBounds(thumbLeft, switchTop, thumbRight, switchBottom);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, thumbLeft, switchTop, thumbRight, switchBottom);
            }
        }
        super.draw(c);
    }

    protected void onDraw(Canvas canvas) {
        Layout switchText;
        super.onDraw(canvas);
        Rect padding = this.mTempRect;
        Drawable trackDrawable = this.mTrackDrawable;
        if (trackDrawable != null) {
            trackDrawable.getPadding(padding);
        } else {
            padding.setEmpty();
        }
        int switchTop = this.mSwitchTop;
        int switchBottom = this.mSwitchBottom;
        int switchInnerTop = switchTop + padding.top;
        int switchInnerBottom = switchBottom - padding.bottom;
        Drawable thumbDrawable = this.mThumbDrawable;
        if (trackDrawable != null) {
            trackDrawable.draw(canvas);
        }
        int saveCount = canvas.save();
        if (thumbDrawable != null) {
            thumbDrawable.draw(canvas);
        }
        if (getTargetCheckedState()) {
            switchText = this.mOnLayout;
        } else {
            switchText = this.mOffLayout;
        }
        if (switchText != null) {
            int cX;
            int[] drawableState = getDrawableState();
            if (this.mTextColors != null) {
                this.mTextPaint.setColor(this.mTextColors.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (thumbDrawable != null) {
                Rect bounds = thumbDrawable.getBounds();
                cX = bounds.left + bounds.right;
            } else {
                cX = getWidth();
            }
            canvas.translate((float) ((cX / TOUCH_MODE_DRAGGING) - (switchText.getWidth() / TOUCH_MODE_DRAGGING)), (float) (((switchInnerTop + switchInnerBottom) / TOUCH_MODE_DRAGGING) - (switchText.getHeight() / TOUCH_MODE_DRAGGING)));
            switchText.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int padding = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText())) {
            return padding;
        }
        return padding + this.mSwitchPadding;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int padding = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText())) {
            return padding;
        }
        return padding + this.mSwitchPadding;
    }

    private int getThumbOffset() {
        float thumbPosition;
        if (ViewUtils.isLayoutRtl(this)) {
            thumbPosition = TextTrackStyle.DEFAULT_FONT_SCALE - this.mThumbPosition;
        } else {
            thumbPosition = this.mThumbPosition;
        }
        return (int) ((((float) getThumbScrollRange()) * thumbPosition) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.mTrackDrawable == null) {
            return 0;
        }
        Rect padding = this.mTempRect;
        this.mTrackDrawable.getPadding(padding);
        return ((this.mSwitchWidth - this.mThumbWidth) - padding.left) - padding.right;
    }

    protected int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + TOUCH_MODE_DOWN);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] myDrawableState = getDrawableState();
        if (this.mThumbDrawable != null) {
            this.mThumbDrawable.setState(myDrawableState);
        }
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.setState(myDrawableState);
        }
        invalidate();
    }

    public void drawableHotspotChanged(float x, float y) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(x, y);
        }
        if (this.mThumbDrawable != null) {
            DrawableCompat.setHotspot(this.mThumbDrawable, x, y);
        }
        if (this.mTrackDrawable != null) {
            DrawableCompat.setHotspot(this.mTrackDrawable, x, y);
        }
    }

    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.mThumbDrawable || who == this.mTrackDrawable;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.mThumbDrawable != null) {
                this.mThumbDrawable.jumpToCurrentState();
            }
            if (this.mTrackDrawable != null) {
                this.mTrackDrawable.jumpToCurrentState();
            }
            if (this.mPositionAnimator != null && this.mPositionAnimator.hasStarted() && !this.mPositionAnimator.hasEnded()) {
                clearAnimation();
                this.mPositionAnimator = null;
            }
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(SwitchCompat.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setClassName(SwitchCompat.class.getName());
            CharSequence switchText = isChecked() ? this.mTextOn : this.mTextOff;
            if (!TextUtils.isEmpty(switchText)) {
                CharSequence oldText = info.getText();
                if (TextUtils.isEmpty(oldText)) {
                    info.setText(switchText);
                    return;
                }
                StringBuilder newText = new StringBuilder();
                newText.append(oldText).append(' ').append(switchText);
                info.setText(newText);
            }
        }
    }

    private static float constrain(float amount, float low, float high) {
        if (amount < low) {
            return low;
        }
        return amount > high ? high : amount;
    }
}
