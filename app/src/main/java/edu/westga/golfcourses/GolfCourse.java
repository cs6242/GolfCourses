package edu.westga.golfcourses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wlloyd on 1/18/2016.
 */
public class GolfCourse implements Parcelable {
    private String name = "None";

    private String address = "None";
    private int holes = 18;
    private boolean isPublic;


    public GolfCourse(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Text representation of the class
    public String toString() {
        return this.name + ", " + this.address;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.getName(), this.getAddress()});
    }

    private GolfCourse(Parcel in) {
        String[] data = new String[2];
        in.readStringArray(data);
        this.name = data[0];
        this.address = data[1];
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        /**
         * Create a new instance of the Parcelable class, instantiating it
         * from the given Parcel whose data had previously been written by
         * {@link Parcelable#writeToParcel Parcelable.writeToParcel()}.
         *
         * @param source The Parcel to read the object's data from.
         * @return Returns a new instance of the Parcelable class.
         */
        @Override
        public GolfCourse createFromParcel(Parcel in) {
            return new GolfCourse(in);
        }

        /**
         * Create a new array of the Parcelable class.
         *
         * @param size Size of the array.
         * @return Returns an array of the Parcelable class, with every entry
         * initialized to null.
         */
        @Override
        public Object[] newArray(int size) {
            return new GolfCourse[size];
        }
    };

}
