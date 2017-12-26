package com.kyba.selenide.www.esdev.mediacenter.pagefactory;

import com.codeborne.selenide.SelenideElement;
import com.kyba.selenide.www.esdev.testconfig.ForAllPages;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MediaCenterPage extends ForAllPages {

    //for Class

    public void enableCheckboxEditLibraryStructure() {
        if (!enabledCheckbox.isSelected()) {
            enabledCheckbox.click();
        }
    }

    public SelenideElement enabledCheckbox = $("#mod_ctrl");

    @Step
    public void assertCapabilityEditLibraryStructureWhenCheckboxOff() {
        if (!enabledCheckbox.isSelected()) {
            $(".add_link").shouldNotHave(exactText("Add Class"));
            $(".add_link").shouldNotHave(exactText("Add Category"));
            $(".add_link").shouldNotHave(exactText("Add Subcategory"));
            $(".edit-icon").shouldNotBe(visible);
            $(".delete-icon").shouldNotBe(visible);
        }
    }

    @Step
    public void goToMediaCenter() {
        $("#topmenu_94").click();
    }

    @Step
    public void addClass() {
        $x("//*[.='Add Class']").click();
    }

    @Step
    public void selectCompany(String company) {
        $("#company_id_select").selectOptionContainingText(company);
    }

    @Step
    public void setTitleForClass(String text) {
        $x(".//*[@id='popup_library_form']//tr[2]/td[2]/input").setValue(text);
    }

    @Step
    public void buttonSaveClassClick() {
        $x(".//*[@id='popup_library_form']//tr[3]/td/input[1]").click();
    }

    @Step
    public void assertNewClass(String className) {
        $("#content-library-slider").shouldHave(text(className));
    }

    //for Category

    @Step
    public void addCategory() {
        $x("//*[.='Add Category']").click();
    }

    @Step
    public void selectClass() {
        $x(".//*[@id='content-library-slider']/div/ul/li[1]").click();
    }

    @Step
    public void setTitleForCategory(String text) {
        $x(".//*[@id='popup_library_form']//tr[3]/td[2]/input").setValue(text);
    }

    @Step
    public void buttonSaveCategoryClick() {
        $x(".//*[@id='popup_library_form']//tr[4]/td/input[1]").click();
    }

    public SelenideElement checkNextCategoriesButton = $x("//div[@id='category-list']//button[@class='next']"); //when list of categories have more than 4 categories appear button Next

    @Step
    public void assertNewCategory(String categoryName) throws InterruptedException {
        Thread.sleep(Long.parseLong("2000"));
        if(checkNextCategoriesButton.exists()) {
            $x("//div[@id='category-list']//button[@class='next']").click();
            $("#category-list").shouldHave(text(categoryName));
        }else {
            $("#category-list").shouldHave(text(categoryName));
        }
    }

    // for Subcategory

    @Step
    public void addSubCategory() {
        $x("//*[.='Add Subcategory']").click();
    }

    @Step
    public void setTitleForSubCategory(String text) {
        $x(".//*[@id='popup_library_form']//tr[4]/td[2]/input").setValue(text);
    }

    @Step
    public void buttonSaveSubCategoryClick() {
        $x(".//*[@id='popup_library_form']//tr[5]/td/input[1]").click();
    }

    @Step
    public void assertNewSubCategory(String subCategoryName) {
        $("#list_subcategories").shouldHave(text(subCategoryName));
    }

    // for Campaign

    @Step
    public void addCampaign() {
        $x("//*[.='Add Campaign']").click();
    }

    @Step
    public void setTitleForCampaign(String text) {
        $x(".//*[@id='popup_library_form']//tr[5]/td[2]/input").setValue(text);
    }

    @Step
    public void buttonSaveCampaignClick() {
        $x(".//*[@id='popup_library_form']//tr[6]/td/input[1]").click();
    }

    @Step
    public void assertNewCampaign(String campaignName) {
        $(".tbl_results").shouldHave(text(campaignName));
    }

    @Step
    protected static void assertShowingRecords(int count) {
        $(".nobold>strong").shouldHave(exactText(String.valueOf(count)));
    }

    //manage campaign items

    @Step
    public void manageFirstCampaignItems() {   //select first campaign from the list
        $x(".//table/tbody/tr[2]/td[6]/a[1]").click();
    }

    @Step
    public void manageSecondCampaignItems() {   //select second campaign from the list
        $x(".//table/tbody/tr[3]/td[6]/a[1]").click();
    }

    @Step
    public void addFile() {
        $x("//*[.='Add File']").click();
    }

    @Step
    public void uploadFile(String titleFile) {
        $("#file_upload").sendKeys("file://C:/Users/Frontex user/IdeaProjects/SELENIDE/src/test/java/com/kyba/selenide/www/esdev/resources/" + titleFile);
    }

    @Step
    public void uploadPackage(String titleFile) {
        $("#files").sendKeys("file://C:/Users/Frontex user/IdeaProjects/SELENIDE/src/test/java/com/kyba/selenide/www/esdev/resources/" + titleFile);
    }

    @Step
    public void saveContent() {
        $x(".//*[@id='saveForm']").click();
    }

    @Step
    public void cancelAddContent() {
        $x(".//*[@id='popup_addfiles_form']//tr[28]/td/input[2]").click();
    }

    @Step
    public void savePackage() {
        $x(".//*[@id='popup_addpackage_form']/table/tbody/tr[11]/td/input[1]").click();
    }

    @Step
    public void cancelAddPackage() {
        $x(".//*[@id='popup_addpackage_form']/table/tbody/tr[11]/td/input[2]").click();
    }

    @Step
    protected void editFirstItemInList() {
        $x("//form[@id='apply_action']//tr[2]/td[13]//img[contains(@title, 'Edit')]").click();
    }

    @Step
    protected void setTitle(String text){
        $("#title_file_name").setValue(text);
    }

    @Step
    protected void cleanTitle(){
        $("#title_file_name").clear();
    }

    @Step
    protected void setDuration(String duration){
        $("#timeplay").setValue(duration);
    }

    @Step
    protected void selectLanguage(String lang) {
        $(byName("id_content_language")).selectOptionContainingText(lang);
    }

    @Step
    public void assertAppearNewContent(String titleFile) {
        $(".tbl_results").waitUntil(text(titleFile), 900000);  // 900000  =  waiting 15 minutes until content loading
    }

    @Step
    protected void assertFirstRowColumnTitle(String titleFile){          //for first file in list
        $x("//form[@id='apply_action']//tr[2]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertFirstRowColumnLanguage(String text){          //for first file in list
        $x("//form[@id='apply_action']//tr[2]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertFirstRowColumnMediaType(String type){          //for first file in list
        $x("//form[@id='apply_action']//tr[2]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertFirstRowColumnSize(String size){              //for first file in list
        $x("//form[@id='apply_action']//tr[2]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertFirstRowColumnDuration(String duration){              //for first file in list
        $x("//form[@id='apply_action']//tr[2]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertFirstRowColumnContainer(String text){              //for first file in list
        $x("//form[@id='apply_action']//tr[2]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertFirstRowColumnCodecs(String text){              //for first file in list
        $x("//form[@id='apply_action']//tr[2]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void assertSecondRowColumnTitle(String titleFile){          //for second file in list
        $x("//form[@id='apply_action']//tr[3]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertSecondRowColumnLanguage(String text){          //for second file in list
        $x("//form[@id='apply_action']//tr[3]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertSecondRowColumnMediaType(String type){          //for second file in list
        $x("//form[@id='apply_action']//tr[3]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertSecondRowColumnSize(String size){              //for second file in list
        $x("//form[@id='apply_action']//tr[3]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertSecondRowColumnDuration(String duration){              //for second file in list
        $x("//form[@id='apply_action']//tr[3]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertSecondRowColumnContainer(String text){              //for second file in list
        $x("//form[@id='apply_action']//tr[3]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertSecondRowColumnCodecs(String text){              //for second file in list
        $x("//form[@id='apply_action']//tr[3]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void assertThirdRowColumnTitle(String titleFile){          //for third file in list
        $x("//form[@id='apply_action']//tr[4]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertThirdRowColumnLanguage(String text){          //for third file in list
        $x("//form[@id='apply_action']//tr[4]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertThirdRowColumnMediaType(String type){          //for third file in list
        $x("//form[@id='apply_action']//tr[4]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertThirdRowColumnSize(String size){              //for third file in list
        $x("//form[@id='apply_action']//tr[4]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertThirdRowColumnDuration(String duration){              //for third file in list
        $x("//form[@id='apply_action']//tr[4]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertThirdRowColumnContainer(String text){              //for third file in list
        $x("//form[@id='apply_action']//tr[4]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertThirdRowColumnCodecs(String text){              //for first file in list
        $x("//form[@id='apply_action']//tr[4]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void assertFourthRowColumnTitle(String titleFile){          //for 4 file in list
        $x("//form[@id='apply_action']//tr[5]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertFourthRowColumnLanguage(String text){          //for 4 file in list
        $x("//form[@id='apply_action']//tr[5]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertFourthRowColumnMediaType(String type){          //for 4 file in list
        $x("//form[@id='apply_action']//tr[5]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertFourthRowColumnSize(String size){              //for 4 file in list
        $x("//form[@id='apply_action']//tr[5]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertFourthRowColumnDuration(String duration){              //for 4 file in list
        $x("//form[@id='apply_action']//tr[5]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertFourthRowColumnContainer(String text){              //for 4 file in list
        $x("//form[@id='apply_action']//tr[5]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertFourthRowColumnCodecs(String text){              //for 4 file in list
        $x("//form[@id='apply_action']//tr[5]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void assertFifthRowColumnTitle(String titleFile){          //for 5 file in list
        $x("//form[@id='apply_action']//tr[6]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertFifthRowColumnLanguage(String text){          //for 5 file in list
        $x("//form[@id='apply_action']//tr[6]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertFifthRowColumnMediaType(String type){          //for 5 file in list
        $x("//form[@id='apply_action']//tr[6]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertFifthRowColumnSize(String size){              //for 5 file in list
        $x("//form[@id='apply_action']//tr[6]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertFifthRowColumnDuration(String duration){              //for 5 file in list
        $x("//form[@id='apply_action']//tr[6]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertFifthRowColumnContainer(String text){              //for 5 file in list
        $x("//form[@id='apply_action']//tr[6]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertFifthRowColumnCodecs(String text){              //for 5 file in list
        $x("//form[@id='apply_action']//tr[6]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void assertSixthRowColumnTitle(String titleFile){          //for 6 file in list
        $x("//form[@id='apply_action']//tr[7]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertSixthRowColumnLanguage(String text){          //for 6 file in list
        $x("//form[@id='apply_action']//tr[7]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertSixthRowColumnMediaType(String type){          //for 6 file in list
        $x("//form[@id='apply_action']//tr[7]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertSixthRowColumnSize(String size){              //for 6 file in list
        $x("//form[@id='apply_action']//tr[7]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertSixthRowColumnDuration(String duration){              //for 6 file in list
        $x("//form[@id='apply_action']//tr[7]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertSixthRowColumnContainer(String text){              //for 6 file in list
        $x("//form[@id='apply_action']//tr[7]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertSixthRowColumnCodecs(String text){              //for 6 file in list
        $x("//form[@id='apply_action']//tr[7]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void assertSeventhRowColumnTitle(String titleFile){          //for 7 file in list
        $x("//form[@id='apply_action']//tr[8]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertSeventhRowColumnLanguage(String text){          //for 7 file in list
        $x("//form[@id='apply_action']//tr[8]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertSeventhRowColumnMediaType(String type){          //for 7 file in list
        $x("//form[@id='apply_action']//tr[8]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertSeventhRowColumnSize(String size){              //for 7 file in list
        $x("//form[@id='apply_action']//tr[8]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertSeventhRowColumnDuration(String duration){              //for 7 file in list
        $x("//form[@id='apply_action']//tr[8]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertSeventhRowColumnContainer(String text){              //for 7 file in list
        $x("//form[@id='apply_action']//tr[8]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertSeventhRowColumnCodecs(String text){              //for 7 file in list
        $x("//form[@id='apply_action']//tr[8]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void assertEighthRowColumnTitle(String titleFile){          //for 8 file in list
        $x("//form[@id='apply_action']//tr[9]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertEighthRowColumnLanguage(String text){          //for 8 file in list
        $x("//form[@id='apply_action']//tr[9]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertEighthRowColumnMediaType(String type){          //for 8 file in list
        $x("//form[@id='apply_action']//tr[9]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertEighthRowColumnSize(String size){              //for 8 file in list
        $x("//form[@id='apply_action']//tr[9]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertEighthRowColumnDuration(String duration){              //for 8 file in list
        $x("//form[@id='apply_action']//tr[9]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertEighthRowColumnContainer(String text){              //for 8 file in list
        $x("//form[@id='apply_action']//tr[9]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertEighthRowColumnCodecs(String text){              //for 8 file in list
        $x("//form[@id='apply_action']//tr[9]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void assertNinthRowColumnTitle(String titleFile){          //for 9 file in list
        $x("//form[@id='apply_action']//tr[10]/td[3]/span[1]").waitUntil(text(titleFile), 900000);
    }

    @Step
    protected void assertNinthRowColumnLanguage(String text){          //for 9 file in list
        $x("//form[@id='apply_action']//tr[10]//td[4]/span[1]").shouldHave(text(text));
    }

    @Step
    protected void assertNinthRowColumnMediaType(String type){          //for 9 file in list
        $x("//form[@id='apply_action']//tr[10]//td[5]").shouldHave(text(type));
    }

    @Step
    protected void assertNinthRowColumnSize(String size){              //for 9 file in list
        $x("//form[@id='apply_action']//tr[10]//td[9]").shouldHave(text(size));
    }

    @Step
    protected void assertNinthRowColumnDuration(String duration){              //for 9 file in list
        $x("//form[@id='apply_action']//tr[10]//td[10]").shouldHave(text(duration));
    }

    @Step
    protected void assertNinthRowColumnContainer(String text){              //for 9 file in list
        $x("//form[@id='apply_action']//tr[10]//td[11]").shouldHave(text(text));
    }

    @Step
    protected void assertNinthRowColumnCodecs(String text){              //for 9 file in list
        $x("//form[@id='apply_action']//tr[10]//td[12]").shouldHave(text(text));
    }

    @Step
    protected void buttonBackToCampaignList(){
        $x("//*[contains(@title, 'Back to campaign list')]").click();
    }

    @Step
    protected void deleteLastFileInList(){
        $x("(//td[13]/a[4]/img)[last()]").click();
    }

    @Step
    protected void assertDisappearsDeletedFile(String titleFile){          //for third file in list
        $x("//form[@id='apply_action']//tr[4]/td[3]/span[1]").shouldNotBe(visible);
    }

    @Step
    protected void alertDeleteFileOk(){
        $x(".//*[@id='body']//div[@class='aButtons']//button[1]").click();
    }

    @Step
    protected void alertDeleteFileCancel(){
        $x(".//*[@id='body']//div[@class='aButtons']//button[2]").click();
    }

    @Step
    protected void assertNotifications(String message){
        $x("//div[@class='jGrowl-notification default']//div[@class='message']").shouldHave(text((message)));
    }

    @Step
    protected void deleteCurrentSubcategory(){
        $x(".//*[@id='ac']/table/tbody/tr[1]/td[2]/div/a[2]/img").click();
    }

    //content library / check negative cases

    @Step
    public void selectMediaType(String type) {
        $("#type_file_name").selectOptionContainingText(type);
    }

    @Step
    public void assertErrorMessagesInPopup(String message) {
        $(".error").shouldHave(text(message));
    }

    @Step
    public void closePopup() {
        $(".popup_close").click();
    }

    @Step
    public void addPackageClick() {
        $x("//*[.='Add Package']").click();
    }

    @Step
    public void alertDurationOk() {
        $x(".//*[@id='body']/div[7]//button[1]").click();  //Duration is set to zero. If duration cannot be determined for the items automatically, default values of the corresponding media types will be used.
    }
}
