package org.example.bai5.model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
    @Value("Duong Duc Loc")
    private String branchName;

    @Value("10:00")
    private String openingHour;

    public String getBranchName() {
        return branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }
}
