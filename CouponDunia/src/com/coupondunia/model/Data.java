
package com.coupondunia.model;


import java.util.ArrayList;
import java.util.List;

public class Data {

	private String CurrentLocation;
	
    private String SubFranchiseID;
    private String OutletID;
    private String OutletName;
    private String BrandID;
    private String Address;
    private String NeighbourhoodID;
    private String CityID;
    private Object Email;
    private String Timings;
    private Object CityRank;
    private String Latitude;
    private String Longitude;
    private Object Pincode;
    private Object Landmark;
    private Object Streetname;
    private String BrandName;
    private String OutletURL;
    private Integer NumCoupons;
    private String NeighbourhoodName;
    private String PhoneNumber;
    private String CityName;
    private Double Distance;
    private List<Category> Categories=new ArrayList<Category>();
    private String LogoURL;
    private String CoverURL;    
    private String categoriesString;

    /**
     * 
     * @return
     *     The SubFranchiseID
     */
    public String getSubFranchiseID() {
        return SubFranchiseID;
    }

    /**
     * 
     * @param SubFranchiseID
     *     The SubFranchiseID
     */
    public void setSubFranchiseID(String SubFranchiseID) {
        this.SubFranchiseID = SubFranchiseID;
    }

    /**
     * 
     * @return
     *     The OutletID
     */
    public String getOutletID() {
        return OutletID;
    }

    /**
     * 
     * @param OutletID
     *     The OutletID
     */
    public void setOutletID(String OutletID) {
        this.OutletID = OutletID;
    }

    /**
     * 
     * @return
     *     The OutletName
     */
    public String getOutletName() {
        return OutletName;
    }

    /**
     * 
     * @param OutletName
     *     The OutletName
     */
    public void setOutletName(String OutletName) {
        this.OutletName = OutletName;
    }

    /**
     * 
     * @return
     *     The BrandID
     */
    public String getBrandID() {
        return BrandID;
    }

    /**
     * 
     * @param BrandID
     *     The BrandID
     */
    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    /**
     * 
     * @return
     *     The Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * 
     * @param Address
     *     The Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * 
     * @return
     *     The NeighbourhoodID
     */
    public String getNeighbourhoodID() {
        return NeighbourhoodID;
    }

    /**
     * 
     * @param NeighbourhoodID
     *     The NeighbourhoodID
     */
    public void setNeighbourhoodID(String NeighbourhoodID) {
        this.NeighbourhoodID = NeighbourhoodID;
    }

    /**
     * 
     * @return
     *     The CityID
     */
    public String getCityID() {
        return CityID;
    }

    /**
     * 
     * @param CityID
     *     The CityID
     */
    public void setCityID(String CityID) {
        this.CityID = CityID;
    }

    /**
     * 
     * @return
     *     The Email
     */
    public Object getEmail() {
        return Email;
    }

    /**
     * 
     * @param Email
     *     The Email
     */
    public void setEmail(Object Email) {
        this.Email = Email;
    }

    /**
     * 
     * @return
     *     The Timings
     */
    public String getTimings() {
        return Timings;
    }

    /**
     * 
     * @param Timings
     *     The Timings
     */
    public void setTimings(String Timings) {
        this.Timings = Timings;
    }

    /**
     * 
     * @return
     *     The CityRank
     */
    public Object getCityRank() {
        return CityRank;
    }

    /**
     * 
     * @param CityRank
     *     The CityRank
     */
    public void setCityRank(Object CityRank) {
        this.CityRank = CityRank;
    }

    /**
     * 
     * @return
     *     The Latitude
     */
    public String getLatitude() {
        return Latitude;
    }

    /**
     * 
     * @param Latitude
     *     The Latitude
     */
    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    /**
     * 
     * @return
     *     The Longitude
     */
    public String getLongitude() {
        return Longitude;
    }

    /**
     * 
     * @param Longitude
     *     The Longitude
     */
    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    /**
     * 
     * @return
     *     The Pincode
     */
    public Object getPincode() {
        return Pincode;
    }

    /**
     * 
     * @param Pincode
     *     The Pincode
     */
    public void setPincode(Object Pincode) {
        this.Pincode = Pincode;
    }

    /**
     * 
     * @return
     *     The Landmark
     */
    public Object getLandmark() {
        return Landmark;
    }

    /**
     * 
     * @param Landmark
     *     The Landmark
     */
    public void setLandmark(Object Landmark) {
        this.Landmark = Landmark;
    }

    /**
     * 
     * @return
     *     The Streetname
     */
    public Object getStreetname() {
        return Streetname;
    }

    /**
     * 
     * @param Streetname
     *     The Streetname
     */
    public void setStreetname(Object Streetname) {
        this.Streetname = Streetname;
    }

    /**
     * 
     * @return
     *     The BrandName
     */
    public String getBrandName() {
        return BrandName;
    }

    /**
     * 
     * @param BrandName
     *     The BrandName
     */
    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    /**
     * 
     * @return
     *     The OutletURL
     */
    public String getOutletURL() {
        return OutletURL;
    }

    /**
     * 
     * @param OutletURL
     *     The OutletURL
     */
    public void setOutletURL(String OutletURL) {
        this.OutletURL = OutletURL;
    }

    /**
     * 
     * @return
     *     The NumCoupons
     */
    public Integer getNumCoupons() {
        return NumCoupons;
    }

    /**
     * 
     * @param NumCoupons
     *     The NumCoupons
     */
    public void setNumCoupons(Integer NumCoupons) {
        this.NumCoupons = NumCoupons;
    }

    /**
     * 
     * @return
     *     The NeighbourhoodName
     */
    public String getNeighbourhoodName() {
        return NeighbourhoodName;
    }

    /**
     * 
     * @param NeighbourhoodName
     *     The NeighbourhoodName
     */
    public void setNeighbourhoodName(String NeighbourhoodName) {
        this.NeighbourhoodName = NeighbourhoodName;
    }

    /**
     * 
     * @return
     *     The PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * 
     * @param PhoneNumber
     *     The PhoneNumber
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * 
     * @return
     *     The CityName
     */
    public String getCityName() {
        return CityName;
    }

    /**
     * 
     * @param CityName
     *     The CityName
     */
    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    /**
     * 
     * @return
     *     The Distance
     */
    public Double getDistance() {
        return Distance;
    }

    /**
     * 
     * @param Distance
     *     The Distance
     */
    public void setDistance(Double Distance) {
        this.Distance = Distance;
    }

    /**
     * 
     * @return
     *     The Categories
     */
    public List<Category> getCategories() {
        return Categories;
    }

    /**
     * 
     * @param Categories
     *     The Categories
     */
    public void setCategories(List<Category> Categories) {
        this.Categories = Categories;
    }

    /**
     * 
     * @return
     *     The LogoURL
     */
    public String getLogoURL() {
        return LogoURL;
    }

    /**
     * 
     * @param LogoURL
     *     The LogoURL
     */
    public void setLogoURL(String LogoURL) {
        this.LogoURL = LogoURL;
    }

    /**
     * 
     * @return
     *     The CoverURL
     */
    public String getCoverURL() {
        return CoverURL;
    }

    /**
     * 
     * @param CoverURL
     *     The CoverURL
     */
    public void setCoverURL(String CoverURL) {
        this.CoverURL = CoverURL;
    }

	public String getCurrentLocation() {
		return CurrentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		CurrentLocation = currentLocation;
	}

	public String getCategoriesString() {
		return categoriesString;
	}

	public void setCategoriesString(String categoriesString) {
		this.categoriesString = categoriesString;
	}
    
   
}

