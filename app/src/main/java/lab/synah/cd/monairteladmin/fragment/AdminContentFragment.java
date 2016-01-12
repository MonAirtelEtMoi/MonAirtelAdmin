package lab.synah.cd.monairteladmin.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import lab.synah.cd.monairteladmin.R;
import yalantis.com.sidemenu.interfaces.ScreenShotable;

/**
 * Created by Michelo on 06/01/16.
 */
public class AdminContentFragment extends Fragment implements ScreenShotable {

    public static final String CLOSE = "Close";
    public static final String USSD = "Ussd";
    public static final String SUSCRIBER = "Suscriber";
    public static final String COMMANDE = "Commande";


    private View containerView;
    protected ImageView mImageView;
    protected int res;
    private Bitmap bitmap;

    public static AdminContentFragment newInstance(int resId) {
        AdminContentFragment contentFragment = new AdminContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.containerView = view.findViewById(R.id.container);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getArguments().getInt(Integer.class.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_admin_content, container, false);
        mImageView = (ImageView) rootView.findViewById(R.id.image_content);
        mImageView.setClickable(true);
        mImageView.setFocusable(true);
        mImageView.setImageResource(res);
        return rootView;
    }

    @Override
    public void takeScreenShot() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Bitmap bitmap = Bitmap.createBitmap(containerView.getWidth(),
                        containerView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                containerView.draw(canvas);
                AdminContentFragment.this.bitmap = bitmap;
            }
        };

        thread.start();

    }




    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }




}
