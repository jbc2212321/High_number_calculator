package com.example.sympyandroid002;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.sympyandroid002.databinding.FragmentDiffBinding;

import java.util.Objects;

import io.noties.markwon.Markwon;
import io.noties.markwon.ext.latex.JLatexMathPlugin;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiffFragment extends Fragment {
    private EditText editText1;
    private FragmentDiffBinding binding;
    public DiffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDiffBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Markwon markwon = Markwon.builder(Objects.requireNonNull(getContext()))
                // required plugin to support inline parsing
                .usePlugin(MarkwonInlineParserPlugin.create())
                .usePlugin(JLatexMathPlugin.create(binding.diffTextViewDisplay.getTextSize(), new JLatexMathPlugin.BuilderConfigure() {
                    @Override
                    public void configureBuilder(@NonNull JLatexMathPlugin.Builder builder) {
                        // ENABLE inlines
                        builder.inlinesEnabled(true);
                    }
                }))
                .build();
        initPython();
        final Python python = Python.getInstance();
        String show = " 只对输入的变量求导";
        binding.diffTextViewDisplay.setText("");
        binding.diffButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_diffFragment_to_homeFragment);
            }
        });

        binding.diffButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String latex = String.valueOf(binding.diffEditText1.getText());
                String symbol = String.valueOf(binding.diffEditText2.getText());
                String order = String.valueOf(binding.diffEditText3.getText());
                String answer = String.valueOf(python.getModule("High_number").callAttr("high_diff",latex,symbol,Integer.parseInt(order)));
                answer="$$\n"+answer+"\n$$";
                markwon.setMarkdown(binding.diffTextViewDisplay,answer);
//

            }
        });
    }
    private void initPython(){
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(Objects.requireNonNull(getContext())));
        }
    }
}
