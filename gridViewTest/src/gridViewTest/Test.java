package gridViewTest;

import java.util.ArrayList;
import java.util.List;






import com.example.gridviewtest.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Test extends Activity{
	private ViewPager headAdViewPager;
	private ViewGroup dotsView;
	int[] dotImgId = { R.id.dot_first, R.id.dot_second, R.id.dot_third, R.id.dot_fourth };
	@ViewInject(R.id.imageView)
	ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.carousel_test);
		ViewUtils.inject(this);
		headAdViewPager=(ViewPager) findViewById(R.id.head_view_pager);
		dotsView=(ViewGroup) findViewById(R.id.dot_views);
		setHeadAdView();
		setImage();
	}

	private void setImage() {
		BitmapUtils bitmapUtils = new BitmapUtils(this);
		bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);
		bitmapUtils.display(image, "http://khojatv.streamakaci.com/photo/11751471_943139269082437_1072776626634300817_n.jpg");
	}

	private void setHeadAdView() {
		new HeadAdView(this, getImgUrlList(), headAdViewPager, getDotList(dotsView)).setHeadAd();
	}

	/** 
	 * @Description: 将圆点放入集合中
	 * @param viewGroup void 返回类型  
	 * @throws:throws
	*/

	private List<ImageView> getDotList(ViewGroup viewGroup) {
		List<ImageView> dotList = new ArrayList<ImageView>();
		for (int index = 0; index < dotImgId.length; index++) {
			dotList.add((ImageView) viewGroup.findViewById(dotImgId[index]));
		}
		return dotList;
	}

	/** 
	 * @Description: 获取图片地址集合
	 * @return List<String> 返回类型  
	 * @throws:throws
	*/

	private List<String> getImgUrlList() {
		List<String> imgUrls = new ArrayList<String>();
		imgUrls.add("http://khojatv.streamakaci.com/photo/11751471_943139269082437_1072776626634300817_n.jpg");
		imgUrls.add("http://khojatv.streamakaci.com/photo/11800617_943143309082033_1072474070107504696_n.jpg");
		imgUrls.add("http://khojatv.streamakaci.com/photo/11228022_943141085748922_5721739835222207692_n.jpg");
		imgUrls.add("http://khojatv.streamakaci.com/photo/11800282_943149885748042_752423011326933952_n.jpg");
		return imgUrls;
	}


}
