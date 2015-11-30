package jm.dodamdodam.dodamdodam.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.R;
import jm.dodamdodam.dodamdodam.data.DiaryModel;

/**
 * Created by IronFactory on 15. 11. 29..
 */
public class ViewWordFragment extends Fragment {

    private static final String TAG = "ViewWordFragment";

    private DiaryModel diary;

    private TextView wordView;

    public static ViewWordFragment newInstance(DiaryModel diary) {
        ViewWordFragment fragment = new ViewWordFragment();
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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_word, container, false);
        init(rootView);
        return rootView;
    }


    private void init(View rootView) {
        wordView = (TextView) rootView.findViewById(R.id.fragment_view_word_text);
        wordView.setText(diary.getWord());
    }
}
