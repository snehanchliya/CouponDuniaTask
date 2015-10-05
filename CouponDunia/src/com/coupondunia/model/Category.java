package com.coupondunia.model;

public class Category {

	private String OfflineCategoryID;
	private String Name;
	private String ParentCategoryID;
	private String CategoryType;

	/**
	 * 
	 * @return The OfflineCategoryID
	 */
	public String getOfflineCategoryID() {
		return OfflineCategoryID;
	}

	/**
	 * 
	 * @param OfflineCategoryID
	 *            The OfflineCategoryID
	 */
	public void setOfflineCategoryID(String OfflineCategoryID) {
		this.OfflineCategoryID = OfflineCategoryID;
	}

	/**
	 * 
	 * @return The Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * 
	 * @param Name
	 *            The Name
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * 
	 * @return The ParentCategoryID
	 */
	public String getParentCategoryID() {
		return ParentCategoryID;
	}

	/**
	 * 
	 * @param ParentCategoryID
	 *            The ParentCategoryID
	 */
	public void setParentCategoryID(String ParentCategoryID) {
		this.ParentCategoryID = ParentCategoryID;
	}

	/**
	 * 
	 * @return The CategoryType
	 */
	public String getCategoryType() {
		return CategoryType;
	}

	/**
	 * 
	 * @param CategoryType
	 *            The CategoryType
	 */
	public void setCategoryType(String CategoryType) {
		this.CategoryType = CategoryType;
	}

}
