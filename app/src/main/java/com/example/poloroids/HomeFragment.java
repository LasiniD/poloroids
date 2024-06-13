package com.example.poloroids;

import static android.app.Activity.RESULT_OK;

/*import static androidx.camera.camera2.internal.Camera2CaptureRequestBuilder.build;*/

import static androidx.camera.core.impl.utils.ContextUtil.getApplicationContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.poloroids.databinding.ActivityMainBinding;

import androidx.lifecycle.Observer;
import androidx.lifecycle.LiveData;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import androidx.camera.core.*; // For ProcessCameraProvider, Preview, CameraSelector
import androidx.core.content.ContextCompat; // For ContextCompat
import android.util.Log; // For Log



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    Button button , buttonCam;
    TextView textView;
    ImageView imageView;
    private Uri selectedImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageView = view.findViewById(R.id.imggallery);
        button = view.findViewById(R.id.btnload);
        buttonCam = view.findViewById(R.id.btncam);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);
            }
        });

        /*buttonCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageCapture.OutputFileOptions outputFileOptions =
                        new ImageCapture.OutputFileOptions.Builder(new File(...)).build();
                imageCapture.takePicture(outputFileOptions, cameraExecutor,
                        new ImageCapture.OnImageSavedCallback() {
                            @Override
                            public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
                                // insert your code here.
                            }
                            @Override
                            public void onError(ImageCaptureException error) {
                                // insert your code here.
                            }
                        }
                );
            }
        });*/

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data!= null){
            Uri selectedImage = data.getData();
            /*imageView = imageView.findViewById(R.id.imggallery);*/
            imageView.setImageURI(selectedImage);
        }
    }

   /*private static final String[] REQUIRED_PERMISSIONS = new String[]{
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };*/
 /*
    private ActivityResultLauncher<String[]> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.RequestMultiplePermissions(),
            permissions -> {
                boolean permissionGranted = true;
                for (Map.Entry<String, Boolean> entry : permissions.entrySet()) {
                    if (Arrays.asList(REQUIRED_PERMISSIONS).contains(entry.getKey()) && !entry.getValue()) {
                        permissionGranted = false;
                        break;
                    }
                }
                if (!permissionGranted) {
                    Toast.makeText(requireContext(), "Permission request denied", Toast.LENGTH_SHORT).show();
                } else {
                    startCamera();
                }
            });*/

    /*private void requestPermissions() {
        activityResultLauncher.launch(REQUIRED_PERMISSIONS);
    }*/

    /*private void startCamera() {
        // Get a reference to the ProcessCameraProvider
        ProcessCameraProvider cameraProviderFuture = ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    // Get the camera provider
                    ProcessCameraProvider cameraProvider = cameraProviderFuture.get();

                    // Build the preview use case
                    Preview preview = viewBinding.preview;

                    // Select the back camera
                    CameraSelector cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;

                    // Unbind any existing use cases
                    cameraProvider.unbindAll();

                    // Bind the preview use case to the lifecycle owner
                    cameraProvider.bindToLifecycle(
                            HomeFragment.this,  // Assuming this is a HomeFragment instance
                            cameraSelector, preview);

                } catch (Exception exc) {
                    Log.e(getTag(), "Use case binding failed", exc);
                }
            }
        }, ContextCompat.getMainExecutor(this));
    }
*/
}