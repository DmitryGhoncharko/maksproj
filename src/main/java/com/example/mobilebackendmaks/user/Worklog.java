package com.example.mobilebackendmaks.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "worklogs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Worklog {
    @Id
    @Column(name = "worklogs_id")
    private String worklogId;

    @Column(name = "worklogs_description")
    private String description;

    @Column(name = "worklogs_working_hours")
    private int workingHours;

    @Column(name = "worklogs_log_date")
    private Date logDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worklogs_task_id")
    private Task task;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worklogs_project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worklogs_user_id")
    private User user;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Worklog worklog = (Worklog) o;
        return getWorklogId() != null && Objects.equals(getWorklogId(), worklog.getWorklogId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
