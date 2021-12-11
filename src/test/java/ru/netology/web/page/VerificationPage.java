package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import ru.netology.web.data.DataHelper;

import java.sql.DriverManager;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static ru.netology.web.data.UserGenerator.getVerificationCode;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    @SneakyThrows
    public DashboardPage validVerify(String verificationCode) {

        codeField.setValue(getVerificationCode("vasya"));
        verifyButton.click();
        return new DashboardPage();
    }

}