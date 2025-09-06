package com.trust.pmegpcustomeronboardingapp.activity.services;

import com.trust.pmegpcustomeronboardingapp.activity.model.AdharOtpRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.AdharOtpResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AdharVerificationResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyShortCodeResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyShortCodes;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDataModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantInfoModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantUpdateResult;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicationResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.BankDetailRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.BankDetailResponce;
import com.trust.pmegpcustomeronboardingapp.activity.model.BankModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.DRPMasterData;
import com.trust.pmegpcustomeronboardingapp.activity.model.DistrictModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.EDPRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.EDPResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.GenderModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.InformationSource;
import com.trust.pmegpcustomeronboardingapp.activity.model.LoginRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.LoginResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICDevisionModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICGroupModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.QualificationModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ResultModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ScoreCard;
import com.trust.pmegpcustomeronboardingapp.activity.model.SocialCategory;
import com.trust.pmegpcustomeronboardingapp.activity.model.SpecialCategory;
import com.trust.pmegpcustomeronboardingapp.activity.model.StateModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.SubDistrictRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.SubDistrictResponce;
import com.trust.pmegpcustomeronboardingapp.activity.model.UidRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitDetailResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitTypeIdModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitTypeModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailRequestModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @GET("MobileApp/GetStates")
    Call<List<StateModel>> getStateList();

    @GET("MobileApp/GetAgency")
    Call<List<AgencyModel>> getAgencyList();

    @POST("MobileApp/GetAgencyShortCode")
    Call<AgencyShortCodeResponse> getAgencyShortCode(@Body AgencyModel agencyId);


    @GET("MobileApp/GetUnitTypeActivity")
    Call<List<UnitTypeModel>> getUnitType();

    @POST("MobileApp/GetDistricts")
    Call<List<DistrictModel>> getDistrictList(@Body DistrictModel stateCode);

    @POST("MobileApp/GetQualification")
    Call<List<QualificationModel>> getQualificationList(@Body String qualificationdesc);

    @POST("MobileApp/GetSocialCategory")
    Call<List<SocialCategory>> getSocialCategory(@Body String socialMainCode);

    @POST("MobileApp/GetSpecialCategory")
    Call<List<SpecialCategory>> getSpecialCategory(@Body String splCode);

    @POST("MobileApp/GetInformationSource")
    Call<List<InformationSource>> getInformationSource(@Body String infoSrc);
    @POST("MobileApp/GetGender")
    Call<List<GenderModel>> getGender(@Body String gender);


    @POST("MobileApp/GetAgencyOffDetails")
    Call<List<AgencyResponse>> getAgencyOffDetails(@Body AgencyRequest infoSrc);


    @POST("MobileApp/GetEDPData")
    Call<EDPResponse> getEDPData(@Body EDPRequest request);
    @POST("MobileApp/GetSubDistricts")
    Call<List<SubDistrictResponce>> GetSubDistricts(@Body SubDistrictRequest request);
    @POST("MobileApp/GetVillages")
    Call<List<VillageDetailModel>> getVillages(@Body VillageRequest villageRequest);

    @POST("MobileApp/GetVillageDetails")
    Call<UnitDetailResponse> getVillageDetails(@Body VillageDetailRequestModel villageRequest);

    @GET("MobileApp/GetBankList")
    Call<List<BankModel>> getBankList();

    @POST("MobileApp/GetBranchListData")
    Call<List<BankDetailResponce>> getBankDetailsData(@Body BankDetailRequest bankDetailRequest);

    @POST("MobileApp/GetNIC_DataLevelOne")
    Call<List<NICDevisionModel>> getNICDevisionData(@Body UnitTypeIdModel unitidRequest);

    @POST("MobileApp/GetNIC_DataLevelTwo")
    Call<List<NICGroupModel>> getNICGroupData(@Body NICDevisionModel nicCodeRequest);

    @POST("MobileApp/GetNIC_DataLevelThree")
    Call<List<NICGroupModel>> getNICClassData(@Body NICDevisionModel nicCodeRequest);

    @POST("MobileApp/GetNIC_DataLevelFour")
    Call<List<NICGroupModel>> getNICDataList(@Body NICDevisionModel nicCodeRequest);

    @POST("MobileApp/GETAadharOTP")
    Call<AdharOtpResponse> getAdharOtp(@Body UidRequest adharNo);

    @POST("MobileApp/ValidateAadharOTP")
    Call<AdharVerificationResponse> verifyOtp(@Body AdharOtpRequest adharOtpRequest);


    @POST("MobileApp/SaveApplicantData")
    Call<ResultModel> saveForm(@Body ApplicantDataModel applicantDataModel);

    @POST("MobileApp/AuthenticateApplLogin")
    Call<LoginResponse> loginAuthentication(@Body LoginRequest loginRequest);

    @POST("MobileApp/GetApplicantData")
    Call<ApplicationResponse>  getApplicantData(@Body ApplicantRequest applId);

    @POST("MobileApp/GetDprData")
    Call<DPRResponse>  getDprData(@Body ApplicantRequest applId);


    @POST("MobileApp/GetSavedDPRMasterData")
    Call<DRPMasterData>  getSavedDPRMasterData(@Body ApplicantRequest applId);

    @POST("MobileApp/ScoreCard")
    Call<ScoreCard>  getScoreCardData(@Body ApplicantRequest applId);

    @POST("MobileApp/UpdateApplicantData")
    Call<ApplicantUpdateResult>  updateApplicantData(@Body ApplicantInfoModel applicantInfoModel);
}
