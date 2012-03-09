package fr.tfjgeorge.applepiechart;

import java.util.Collection;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieChart extends View {

	private Collection<Float> data;
	private float total;
	private int color = 0xffaa0000;
	private int nextColor = 0x00212356;

	public PieChart(Context context) {
		super(context);
	}

	public PieChart(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public PieChart(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMinimumWidth(50);
		setMinimumHeight(Math.max(getWidth(), 50));
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	public void setData(Collection<Float> data) {
		this.data = data;
		total = 0f;
		for (float element : data) {
			total += element;
		}
		this.invalidate();
	}

	public void onDraw(Canvas canvas) {
		RectF wrapper = new RectF(0, 0, canvas.getWidth(), canvas.getWidth());
		Paint paint;
		float start = 0;
		for (float element : data) {
			paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(color);
			canvas.drawArc(wrapper, start / total * 360f, element / total
					* 360f, true, paint);
			start += element;
			color += nextColor;
		}
	}
}
