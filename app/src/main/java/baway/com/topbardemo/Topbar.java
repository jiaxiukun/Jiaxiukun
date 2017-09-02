package baway.com.topbardemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * UI模板
 * 本例实现的Topbar，左右两边是一个Button，中间是一个TextView
 * 可根据思路实现自己的UI模板
 */
public class Topbar extends RelativeLayout {
    //需要填充的组件
    private Button leftButton,rightButton;
    private TextView tvTitle;

    //左边的Button
    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    //右边的Button
    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    //中间的Title
    private float titleTextSize;
    private int titleTextColor;
    private String title;

    //给组件设计布局参数
    private LayoutParams leftParams,rightParams,titleParams;

    /**
     * 自定义接口方法
     */
    private topbarClickListener listener;

    public interface topbarClickListener{
        void leftButtonClick();
        void rightButtonClick();
    }

    public void setOnTopbarClickListener(topbarClickListener listener){
        this.listener=listener;
    }



    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**
         * 获取自定义属性
         */
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.Topbar);

        leftTextColor=ta.getColor(R.styleable.Topbar_leftTextColor, 0);
        leftBackground=ta.getDrawable(R.styleable.Topbar_leftBackground);
        leftText=ta.getString(R.styleable.Topbar_leftText);

        rightTextColor=ta.getColor(R.styleable.Topbar_rightTextColor, 0);
        rightBackground=ta.getDrawable(R.styleable.Topbar_rightBackground);
        rightText=ta.getString(R.styleable.Topbar_rightText);

        titleTextSize=ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
        titleTextColor=ta.getColor(R.styleable.Topbar_titleTextColor, 0);
        title=ta.getString(R.styleable.Topbar_title);

        ta.recycle();//避免浪费资源和缓存引起的一些的错误

        /**
         * 实例化要填充的组件、绑定属性值
         */
        leftButton=new Button(context);
        rightButton=new Button(context);
        tvTitle=new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setText(title);
        tvTitle.setGravity(Gravity.CENTER);

        setBackgroundColor(0xFFF59563);//整个topbar背景颜色,可以在布局文件中设置

        /**
         * 将要填充的组件添加到View中、赋给属性值
         */
        leftParams=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftButton, leftParams);

        rightParams=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rightButton,rightParams);

        titleParams=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(tvTitle,titleParams);

        /**
         * 使用接口定义方法
         */
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftButtonClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightButtonClick();
            }
        });

    }

    /**
     * 示例：添加模板方法控制leftButton是否显示
     * 可参照添加其他模板方法
     */
    public void setLeftIsVisiable(boolean flag){
        if (flag){
            leftButton.setVisibility(View.VISIBLE);
        }else {
            leftButton.setVisibility(View.GONE);
        }
    }

}
