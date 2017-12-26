package com.kyba.selenide.www.esdev.mediacenter;

import com.codeborne.selenide.Condition;
import com.kyba.selenide.www.esdev.mediacenter.pagefactory.MediaCenterPage;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;

public class ContentLibraryTest extends MediaCenterPage {

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewClassCategorySubcategoryCampaign() throws InterruptedException {

        goToMediaCenter();
        checkTitleOfBrowserTab("Content Library / Media Center");
        assertCapabilityEditLibraryStructureWhenCheckboxOff();
        enableCheckboxEditLibraryStructure();

        addClass();
        selectCompany("Default Company");
        setTitleForClass(UniqueName + "_class");
        buttonSaveClassClick();
        assertNewClass(UniqueName + "_class");

        addCategory();
        setTitleForCategory(UniqueName + "_category");
        buttonSaveCategoryClick();
        assertNewCategory(UniqueName + "_category");

        addSubCategory();
        setTitleForSubCategory(UniqueName + "_subcategory");
        buttonSaveSubCategoryClick();
        assertNewSubCategory(UniqueName + "_subcategory");

        addCampaign();
        setTitleForCampaign(UniqueName + "_campaign");
        buttonSaveCampaignClick();
        assertNewCampaign(UniqueName + "_campaign");

        manageFirstCampaignItems();
        addFile();
        saveContent();
        assertErrorMessagesInPopup("Please, fill all required fields");
        closePopup();

        addFile();
        selectMediaType("Image (*.jpg, *.png, *.bmp, *.gif, *.jpeg)");
        saveContent();
        assertErrorMessagesInPopup("Please, fill all required fields");
        closePopup();

        addFile();
        setTitle("test");
        saveContent();
        assertErrorMessagesInPopup("Please, fill all required fields");
        cancelAddContent();

        addFile();
        selectMediaType("Video (*.avi, *.mpeg, *.mpg, *.vob, *.mov, *.wmv, *.flv, *.m4v, *.mp4)");
        setTitle("test content library");
        saveContent();
        assertErrorMessagesInPopup("File has not been selected");
        cancelAddContent();

        addPackageClick();
        uploadPackage("notZip.png");
        assertErrorMessagesInPopup("png - invalid format of the uploaded file.");
        savePackage();
        alertDurationOk();
        assertErrorMessagesInPopup("File was not loaded");
        cancelAddPackage();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addImages() throws InterruptedException {

        goToMediaCenter();
        assertCapabilityEditLibraryStructureWhenCheckboxOff();
        enableCheckboxEditLibraryStructure();

        selectClass();
        addCategory();
        setTitleForCategory(UniqueName + "Images");
        buttonSaveCategoryClick();
        assertNewCategory(UniqueName + "Images");

        addSubCategory();
        setTitleForSubCategory(UniqueName + "subcategory");
        buttonSaveSubCategoryClick();
        assertNewSubCategory(UniqueName + "subcategory");

        addCampaign();
        setTitleForCampaign(UniqueName + "Images");
        buttonSaveCampaignClick();
        assertNewCampaign(UniqueName + "Images");

        manageFirstCampaignItems();
        addFile();
        uploadFile("image_jpg.jpg");
        saveContent();
        assertAppearNewContent("image_jpg");

        addFile();
        uploadFile("image_png.png");
        saveContent();
        assertAppearNewContent("image_png");

        addFile();
        uploadFile("gifka_gif.gif");
        saveContent();
        assertAppearNewContent("gifka_gif");

        addFile();
        uploadFile("image_bmp.bmp");
        saveContent();
        assertAppearNewContent("image_bmp");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addQmsFlash() throws InterruptedException {

        goToMediaCenter();
        assertCapabilityEditLibraryStructureWhenCheckboxOff();
        enableCheckboxEditLibraryStructure();

        selectClass();
        addCategory();
        setTitleForCategory(UniqueName + "QMS_flash");
        buttonSaveCategoryClick();
        assertNewCategory(UniqueName + "QMS_flash");

        addSubCategory();
        setTitleForSubCategory(UniqueName + "subcategory");
        buttonSaveSubCategoryClick();
        assertNewSubCategory(UniqueName + "subcategory");

        addCampaign();
        setTitleForCampaign(UniqueName + "QMS");
        buttonSaveCampaignClick();
        assertNewCampaign(UniqueName + "QMS");

        manageFirstCampaignItems();
        addFile();
        uploadFile("QMS_flash_swf-v31.swf");
        saveContent();
        assertAppearNewContent("QMS_flash_swf-v31");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addUnity3dZip() throws InterruptedException {

        goToMediaCenter();
        assertCapabilityEditLibraryStructureWhenCheckboxOff();
        enableCheckboxEditLibraryStructure();

        selectClass();
        addCategory();
        setTitleForCategory(UniqueName + "Unity3d_zip");
        buttonSaveCategoryClick();
        assertNewCategory(UniqueName + "Unity3d_zip");

        addSubCategory();
        setTitleForSubCategory(UniqueName + "subcategory");
        buttonSaveSubCategoryClick();
        assertNewSubCategory(UniqueName + "subcategory");

        addCampaign();
        setTitleForCampaign(UniqueName + "Unity3d");
        buttonSaveCampaignClick();
        assertNewCampaign(UniqueName + "Unity3d");

        manageFirstCampaignItems();
        addFile();
        uploadFile("Unity3d_baloons_zip.zip");
        saveContent();
        assertAppearNewContent("Unity3d_baloons_zip");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("(*.avi, *.mpeg, *.mpg, *.vob, *.mov, *.wmv, *.flv, *.m4v, *.mp4)")
    @Test
    public void addVideos() throws InterruptedException {

        goToMediaCenter();
        assertCapabilityEditLibraryStructureWhenCheckboxOff();
        enableCheckboxEditLibraryStructure();

        selectClass();
        addCategory();
        setTitleForCategory(UniqueName + "Videos");
        buttonSaveCategoryClick();
        assertNewCategory(UniqueName + "Videos");

        addSubCategory();
        setTitleForSubCategory(UniqueName + "subcategory");
        buttonSaveSubCategoryClick();
        assertNewSubCategory(UniqueName + "subcategory");

        addCampaign();
        setTitleForCampaign(UniqueName + "Videos");
        buttonSaveCampaignClick();
        assertNewCampaign(UniqueName + "Videos");

        manageFirstCampaignItems();
        addFile();
        uploadFile("video_mp4.mp4");
        saveContent();
        assertFirstRowColumnTitle("video_mp_4");
        assertFirstRowColumnLanguage("en");
        assertFirstRowColumnMediaType("Video");
        assertFirstRowColumnSize("11.70MB");
        assertFirstRowColumnDuration("00:00:36");
        assertFirstRowColumnContainer("mp4");
        assertFirstRowColumnCodecs("h264 (Constrained Baseline)/aac");

        addFile();
        uploadFile("video_mov.mov");
        saveContent();
        assertSecondRowColumnTitle("video_mov");
        assertSecondRowColumnMediaType("Video");
        assertSecondRowColumnSize("11.43MB");
        assertSecondRowColumnDuration("00:00:12");
        assertSecondRowColumnContainer("mov");

        addFile();
        uploadFile("video_avi.avi");
        saveContent();
        assertThirdRowColumnTitle("video_avi");
        assertThirdRowColumnMediaType("Video");
        assertThirdRowColumnSize("13.24MB");
        assertThirdRowColumnDuration("00:00:30");
        assertThirdRowColumnContainer("avi");
        assertThirdRowColumnCodecs("h264 (Main)/mp3");

        addFile();
        uploadFile("video_mpg.mpg");
        saveContent();
        assertFourthRowColumnTitle("video_mpg");
        assertFourthRowColumnMediaType("Video");
        assertFourthRowColumnSize("40.37MB");
        assertFourthRowColumnDuration("00:00:30");
        assertFourthRowColumnContainer("mpeg");
        assertFourthRowColumnCodecs("mpeg2video (Main)/mp2");

        addFile();
        uploadFile("video_vob.vob");
        saveContent();
        assertFifthRowColumnTitle("video_vob");
        assertFifthRowColumnMediaType("Video");
        assertFifthRowColumnSize("18.02MB");
        assertFifthRowColumnDuration("00:00:36");
        assertFifthRowColumnContainer("mpeg");
        assertFifthRowColumnCodecs("mpeg2video (Main)/mp2");

        addFile();
        uploadFile("video_flv.flv");
        saveContent();
        assertSixthRowColumnTitle("video_flv");
        assertSixthRowColumnMediaType("Video");
        assertSixthRowColumnSize("12.44MB");
        assertSixthRowColumnDuration("00:00:30");
        assertSixthRowColumnContainer("flv");
        assertSixthRowColumnCodecs("flv/aac");

        addFile();
        uploadFile("video_m4v.m4v");
        saveContent();
        assertSeventhRowColumnTitle("video_m4v");
        assertSeventhRowColumnMediaType("Video");
        assertSeventhRowColumnSize("7.76MB");
        assertSeventhRowColumnDuration("00:00:22");
        assertSeventhRowColumnContainer("mov");
        assertSeventhRowColumnCodecs("h264 (Main)/aac");

        addFile();
        uploadFile("video_wmv.wmv");
        saveContent();
        assertEighthRowColumnTitle("video_wmv");
        assertEighthRowColumnMediaType("Video");
        assertEighthRowColumnSize("13.12MB");
        assertEighthRowColumnDuration("00:00:30");
        assertEighthRowColumnContainer("asf");
        assertEighthRowColumnCodecs("vc1 (Advanced)/wmapro");

        addFile();
        uploadFile("video_mpeg.mpeg");
        saveContent();
        assertNinthRowColumnTitle("video_mpeg");
        assertNinthRowColumnMediaType("Video");
        assertNinthRowColumnSize("20.83MB");
        assertNinthRowColumnDuration("00:00:40");
        assertNinthRowColumnContainer("mpeg");
        assertNinthRowColumnCodecs("mpeg1video/mp2");

        assertShowingRecords(9);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("(*.ac3, *.wav, *.wma, *.mp2, *.mp3, *.acc, *.aa, *.aax, *.m4a, *.m4b, *.m4p, *.aif, *.aiff, *.aifc, *.flac)")
    @Test
    public void addAudios() throws InterruptedException {

        goToMediaCenter();       //go to media center / content library
        assertCapabilityEditLibraryStructureWhenCheckboxOff(); //check capability edit library structure when checkbox 'edit library structure' is off
        enableCheckboxEditLibraryStructure();

        selectClass();
        addCategory();
        setTitleForCategory(UniqueName + "Audio");
        buttonSaveCategoryClick();
        assertNewCategory(UniqueName + "Audio");

        addSubCategory();
        setTitleForSubCategory(UniqueName + "subcategory");
        buttonSaveSubCategoryClick();
        assertNewSubCategory(UniqueName + "subcategory");

        addCampaign();
        setTitleForCampaign(UniqueName + "Audio");
        buttonSaveCampaignClick();
        assertNewCampaign(UniqueName + "Audio");

        manageFirstCampaignItems();
        addFile();
        uploadFile("audio_wav.wav");
        saveContent();

        assertFirstRowColumnTitle("audio_wav");
        assertFirstRowColumnLanguage("en");
        assertFirstRowColumnMediaType("Audio");
        assertFirstRowColumnSize("296.31KB");
        assertFirstRowColumnDuration("00:00:37");
        assertFirstRowColumnContainer("wav");
        assertFirstRowColumnCodecs("adpcm_ima_wav");

        editFirstItemInList();
        uploadFile("audio_mp3.mp3");
        cleanTitle();
        setTitle("test 55 symbols Title length not more than 55 symbols55+");  //type 56 symbols
        selectLanguage("Esperanto");
        saveContent();

        Thread.sleep(Long.parseLong("1000"));
        assertFirstRowColumnTitle("test 55 symbols Title length not more than 55 symbols55");  //check 55 symbols
        assertFirstRowColumnLanguage("eo");
        assertFirstRowColumnMediaType("Audio");
        assertFirstRowColumnSize("2.97MB");
        assertFirstRowColumnDuration("00:03:14");
        assertFirstRowColumnContainer("mp3");
        assertFirstRowColumnCodecs("mp3");

        assertShowingRecords(1);

        addFile();
        uploadFile("audio_ac3.ac3");
        saveContent();

        assertSecondRowColumnTitle("audio_ac3");
        assertSecondRowColumnLanguage("en");
        assertSecondRowColumnMediaType("Audio");
        assertSecondRowColumnSize("5.58MB");
        assertSecondRowColumnDuration("00:04:04");
        assertSecondRowColumnContainer("ac3");
        assertSecondRowColumnCodecs("ac3");

        addFile();
        uploadFile("audio_flac.flac");
        saveContent();

        assertThirdRowColumnTitle("audio_flac");
        assertThirdRowColumnLanguage("en");
        assertThirdRowColumnMediaType("Audio");
        assertThirdRowColumnSize("21.02MB");
        assertThirdRowColumnDuration("00:03:59");
        assertThirdRowColumnContainer("flac");
        assertThirdRowColumnCodecs("flac");

        assertShowingRecords(3);

        buttonBackToCampaignList();

        addCampaign();
        setTitleForCampaign(UniqueName + "Audio_31_symbolsX"); //type 31 symbols
        buttonSaveCampaignClick();
        assertNewCampaign(UniqueName + "Audio_31_symbols");  //30 max.

        manageSecondCampaignItems();
        addFile();
        uploadFile("audio_m4a.m4a");
        saveContent();

        assertFirstRowColumnTitle("audio_m4a");
        assertFirstRowColumnLanguage("en");
        assertFirstRowColumnMediaType("Audio");
        assertFirstRowColumnSize("3.00MB");
        assertFirstRowColumnDuration("00:03:13");
        assertFirstRowColumnContainer("m4a");
        assertFirstRowColumnCodecs("aac");

        addFile();
        uploadFile("audio_mp2.mp2");
        saveContent();

        assertSecondRowColumnTitle("audio_mp2");
        assertSecondRowColumnLanguage("en");
        assertSecondRowColumnMediaType("Audio");
        assertSecondRowColumnSize("675.01KB");
        assertSecondRowColumnDuration("00:00:35");
        assertSecondRowColumnContainer("mp3");
        assertSecondRowColumnCodecs("mp2");

        addFile();
        uploadFile("audio_wma.wma");
        saveContent();

        assertThirdRowColumnTitle("audio_wma");
        assertThirdRowColumnLanguage("en");
        assertThirdRowColumnMediaType("Audio");
        assertThirdRowColumnSize("2.82MB");
        assertThirdRowColumnDuration("00:02:51");
        assertThirdRowColumnContainer("asf");
        assertThirdRowColumnCodecs("wmav2");

        assertShowingRecords(3);

        deleteLastFileInList();  //click delete third file in the list
        alertDeleteFileCancel(); //appears alert ok/cancel, click on cancel

        assertThirdRowColumnTitle("audio_wma");  //check third file should be present in the list
        assertShowingRecords(3);                  //showing records should be as before

        deleteLastFileInList();  //click delete third file in the list
        alertDeleteFileOk();     //appears alert ok/cancel, click on ok

        assertDisappearsDeletedFile("audio_wma");  //selected file should be deleted
        assertShowingRecords(2);

        deleteCurrentSubcategory();
        alertDeleteFileOk();

        $(".norecords").shouldHave(Condition.text("There are no available records"));
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Upload package with with three files inside (mp4, jpg, wma)")
    @Test
    public void addPackage() throws InterruptedException {

        goToMediaCenter();
        assertCapabilityEditLibraryStructureWhenCheckboxOff();
        enableCheckboxEditLibraryStructure();

        selectClass();
        addCategory();
        setTitleForCategory(UniqueName + "Package");
        buttonSaveCategoryClick();
        assertNewCategory(UniqueName + "Package");

        addSubCategory();
        setTitleForSubCategory(UniqueName + "subcategory");
        buttonSaveSubCategoryClick();
        assertNewSubCategory(UniqueName + "subcategory");

        addCampaign();
        setTitleForCampaign(UniqueName + "Package");
        buttonSaveCampaignClick();
        assertNewCampaign(UniqueName + "Package");

        manageFirstCampaignItems();
        addPackageClick();
        uploadPackage("Files_zip.zip");
        savePackage();
        alertDurationOk();
        savePackage();

        assertAppearNewContent("testPackage_mp4");
        assertAppearNewContent("testPackage_jpg");
        assertAppearNewContent("testPackage_wma");

        assertFirstRowColumnTitle("testPackage_mp4");
        assertFirstRowColumnLanguage("en");
        assertFirstRowColumnMediaType("Video");
        assertFirstRowColumnSize("9.33MB");
        assertFirstRowColumnDuration("00:03:07");
        assertFirstRowColumnContainer("mp4");
        assertFirstRowColumnCodecs("h264 (Constrained Baseline)/aac");

        assertSecondRowColumnTitle("testPackage_jpg");
        assertSecondRowColumnLanguage("en");
        assertSecondRowColumnMediaType("Image");
        assertSecondRowColumnSize("37.73KB");
        assertSecondRowColumnDuration("00:00:10");
        assertSecondRowColumnContainer("N/A");
        assertSecondRowColumnCodecs("N/A");

        assertThirdRowColumnTitle("testPackage_wma");
        assertThirdRowColumnLanguage("en");
        assertThirdRowColumnMediaType("Audio");
        assertThirdRowColumnSize("627.29KB");
        assertThirdRowColumnDuration("00:02:04");
        assertThirdRowColumnContainer("asf");
        assertThirdRowColumnCodecs("wmav2");

        assertShowingRecords(3);
    }

    String unique = "" + System.currentTimeMillis();
    String UniqueName = "!" + unique;
}
