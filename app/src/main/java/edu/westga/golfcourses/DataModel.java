package edu.westga.golfcourses;

import android.content.Context;
import android.content.res.AssetManager;
import android.provider.MediaStore;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wlloyd on 1/18/2016.
 */
public class DataModel {

    private ArrayList<GolfCourse> courses = new ArrayList<>();
    private Context context;

    public DataModel(Context context, String coursesFileName) {
        AssetManager assetManager = context.getAssets();

        try {
            InputStream inputStream = assetManager.open(coursesFileName);

            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                GolfCourse golfCourse = new GolfCourse(parts[0], parts[1]);
                courses.add(golfCourse);
            }

        } catch (IOException e) {
            return;
        }
    }

    public ArrayList<GolfCourse> getCourses() {
        return this.courses;
    }

}
