package gridViewTest;

import java.util.ArrayList;
import java.util.List;

import com.example.gridviewtest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewTest extends Activity {

	private GridView mGrid;
	private String[] currentOptionsText;
	private static final String[] wash_options_text = { "违章代办", "车蛋购买", "手机充值", "Q币充值" };
	private static int[] wash_options = { R.drawable.carnest_violation, R.drawable.carnest_park_recharge, R.drawable.carnest_phone_recharge, R.drawable.carnest_qq_recharge };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		mGrid = (GridView) findViewById(R.id.grid);
		fillDate();
	}

	private List<Integer> fillDate() {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for (int index = 0; index < wash_options.length; index++) {
			list.add(wash_options[index]);
		}
		currentOptionsText = wash_options_text;

		mGrid.setAdapter(new BaseAbsListAdapter(this, list) {

			@Override
			public View inflate(int position, View convertView, ViewGroup parent) {
				View view = View.inflate(context, R.layout.item, null);
				ImageView image = (ImageView) view.findViewById(R.id.option);
				image.setImageResource(wash_options[position]);
				TextView text = (TextView) view.findViewById(R.id.option_text);
				text.setText("" + currentOptionsText[position]);
				return view;
			}
		});

		return list;
	}
}
