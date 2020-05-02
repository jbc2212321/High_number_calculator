package com.example.sympyandroid002;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sympyandroid002.databinding.FragmentLatexBinding;

import java.util.Objects;

import io.noties.markwon.Markwon;
import io.noties.markwon.ext.latex.JLatexMathPlugin;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;


/**
 * A simple {@link Fragment} subclass.
 */
public class LatexFragment extends Fragment {
    private FragmentLatexBinding binding;
    public LatexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLatexBinding.inflate(getLayoutInflater());
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_latex, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.latexBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_latexFragment_to_homeFragment);
            }
        });
        binding.latexFrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\frac{}{}");
//                binding.latexEditTextInput.setText(temp+"\\frac{}{}");
            }
        });
        binding.latexSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\sqrt[2]{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\sqrt[2]{}");
            }
        });
        binding.latexLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\frac{\\ln{}}{\\ln{}}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\frac{\\ln{}}{\\ln{}}");
            }
        });
        binding.latexLg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\lg{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\lg{}");
            }
        });
        binding.latexLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\ln{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\ln{}");
            }
        });
        binding.latexSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = String.valueOf(binding.latexEditTextInput.getText());
                binding.latexEditTextInput.setText(temp+"\\sin{}");
            }
        });
        binding.latexCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\cos{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\cos{}");
            }
        });
        binding.latexTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\tan{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\tan{}");
            }
        });
        binding.latexArcsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\arcsin{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\arcsin{}");
            }
        });
        binding.latexArccos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\arccos{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\arccos{}");
            }
        });
        binding.latexArctan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\arctan{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\arctan{}");
            }
        });
        binding.latexSb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\^{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"^{}");
            }
        });
        binding.latexXkuohao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"()");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"()");
            }
        });
        binding.latexDkuohao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
////                binding.latexEditTextInput.setText(temp+"\\{}");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"{}");
            }
        });
        binding.latexPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"\\pi");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"\\pi");
            }
        });
        binding.latexE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String temp = String.valueOf(binding.latexEditTextInput.getText());
//                binding.latexEditTextInput.setText(temp+"e");
                int where = binding.latexEditTextInput.getSelectionStart();
                Editable editable = binding.latexEditTextInput.getText();
                editable.insert(where,"e");
            }
        });
        binding.latexClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.latexEditTextInput.setText("");
            }
        });
        binding.latexBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller  = Navigation.findNavController(v);
                controller.navigate(R.id.action_latexFragment_to_homeFragment);
            }
        });
        final Markwon markwon = Markwon.builder(Objects.requireNonNull(getContext()))
                // required plugin to support inline parsing
                .usePlugin(MarkwonInlineParserPlugin.create())
                .usePlugin(JLatexMathPlugin.create(binding.latexTextviewDisplay.getTextSize(), new JLatexMathPlugin.BuilderConfigure() {
                    @Override
                    public void configureBuilder(@NonNull JLatexMathPlugin.Builder builder) {
                        // ENABLE inlines
                        builder.inlinesEnabled(true);
                    }
                }))
                .build();
        binding.latexDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = String.valueOf(binding.latexEditTextInput.getText());
                temp = "$$\n"+temp+"\n$$";
                markwon.setMarkdown(binding.latexTextviewDisplay,temp);
            }
        });
    }
}
