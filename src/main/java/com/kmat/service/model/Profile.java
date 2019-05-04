package com.kmat.service.model;

import java.util.Date;
import java.util.List;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Profile {

	@Id
	private String profileId;
	private String mobile;
	private String placeOfBirth;
	private String height;
	private String weight;
	private String bodyType;
	private String foodHabits;
	private String community;
	private String kootam;
	private String education;
	private String occupation;
	private String currentCity;
	private String maritalStatus;
	private String noOfChildren;
	private String familyType;
	private String familyStatus;
	private String familyValues;
	private String physicalStatus;
	private String annualIncome;
	private String prefferedLocation;
	private String prefferedOccupation;
	private String noOfSiblings;
	private String siblingsMaritalStatus;
	private String fatherOccupation;
	private String fatherContactNo;
	private String moonSign;
	private String lagnam;
	private String star;
	private Date dob;
	private String godName;
	private String godPlace;
	private String firstname;
	private String sex;
	private String lastname;
	private String email;
	private List<Address> address;
	private String timeOfBirth;
	private String faceComplex;
	private boolean dosham;
	private Binary file;

	public Binary getFile() {
		return file;
	}

	public void setFile(Binary file) {
		this.file = file;
	}

	private List<Relationship> relationShip;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Relationship> getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(List<Relationship> relationShip) {
		this.relationShip = relationShip;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getTimeOfBirth() {
		return timeOfBirth;
	}

	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}

	public String getFaceComplex() {
		return faceComplex;
	}

	public void setFaceComplex(String faceComplex) {
		this.faceComplex = faceComplex;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getFoodHabits() {
		return foodHabits;
	}

	public void setFoodHabits(String foodHabits) {
		this.foodHabits = foodHabits;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getKootam() {
		return kootam;
	}

	public void setKootam(String kootam) {
		this.kootam = kootam;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(String noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getFamilyType() {
		return familyType;
	}

	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}

	public String getFamilyStatus() {
		return familyStatus;
	}

	public void setFamilyStatus(String familyStatus) {
		this.familyStatus = familyStatus;
	}

	public String getFamilyValues() {
		return familyValues;
	}

	public void setFamilyValues(String familyValues) {
		this.familyValues = familyValues;
	}

	public String getPhysicalStatus() {
		return physicalStatus;
	}

	public void setPhysicalStatus(String physicalStatus) {
		this.physicalStatus = physicalStatus;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getPrefferedLocation() {
		return prefferedLocation;
	}

	public void setPrefferedLocation(String prefferedLocation) {
		this.prefferedLocation = prefferedLocation;
	}

	public String getNoOfSiblings() {
		return noOfSiblings;
	}

	public void setNoOfSiblings(String noOfSiblings) {
		this.noOfSiblings = noOfSiblings;
	}

	public String getSiblingsMaritalStatus() {
		return siblingsMaritalStatus;
	}

	public void setSiblingsMaritalStatus(String siblingsMaritalStatus) {
		this.siblingsMaritalStatus = siblingsMaritalStatus;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getFatherContactNo() {
		return fatherContactNo;
	}

	public void setFatherContactNo(String fatherContactNo) {
		this.fatherContactNo = fatherContactNo;
	}

	public String getGodName() {
		return godName;
	}

	public void setGodName(String godName) {
		this.godName = godName;
	}

	public String getGodPlace() {
		return godPlace;
	}

	public void setGodPlace(String godPlace) {
		this.godPlace = godPlace;
	}

	public String getPrefferedOccupation() {
		return prefferedOccupation;
	}

	public void setPrefferedOccupation(String prefferedOccupation) {
		this.prefferedOccupation = prefferedOccupation;
	}

	public String getMoonSign() {
		return moonSign;
	}

	public void setMoonSign(String moonSign) {
		this.moonSign = moonSign;
	}

	public String getLagnam() {
		return lagnam;
	}

	public void setLagnam(String lagnam) {
		this.lagnam = lagnam;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public boolean isDosham() {
		return dosham;
	}

	public void setDosham(boolean dosham) {
		this.dosham = dosham;
	}

}
