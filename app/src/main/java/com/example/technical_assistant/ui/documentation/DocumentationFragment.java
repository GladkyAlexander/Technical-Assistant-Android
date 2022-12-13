package com.example.technical_assistant.ui.documentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.technical_assistant.databinding.FragmentDocumentationBinding;

public class DocumentationFragment extends Fragment {

    private FragmentDocumentationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DocumentationViewModel galleryViewModel =
                new ViewModelProvider(this).get(DocumentationViewModel.class);

        binding = FragmentDocumentationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}