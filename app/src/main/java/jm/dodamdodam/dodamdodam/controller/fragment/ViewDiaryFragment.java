package jm.dodamdodam.dodamdodam.controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.data.DiaryModel;

/**
 * Created by IronFactory on 15. 11. 29..
 */
public class ViewDiaryFragment extends Fragment {

    private static final String TAG = "ViewDiaryFragment";

    private DiaryModel diary;

    public static ViewDiaryFragment newInstance(DiaryModel diary) {
        ViewDiaryFragment fragment = new ViewDiaryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Global.DIARY, diary);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        diary = (DiaryModel) getArguments().getSerializable(Global.DIARY);
    }
}
