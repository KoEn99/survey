package com.koen.survey.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "survey_name", nullable = false, length = 500)
    private String surveyName;
    @Column(name = "date_start", nullable = false, length = 25)
    private Date dateStart;
    @Column(name = "date_finish", nullable = false, length = 25)
    private Date dateFinish;
    @Column(name = "is_active", nullable = false, length = 5)
    private boolean isActive;
    @OneToMany(mappedBy = "survey",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuestionSurvey> questionSurveys = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
