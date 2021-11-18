package com.nepalaya.studentmgmt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "STUDENTS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Student implements Serializable {


    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "DOB", nullable = false)
    private Date dob;

    @NotBlank
    @Column(name = "ADDRESS", nullable = false)
    @Size(min = 2, max = 200)
    private String address;

    @NotBlank
    @Column(name = "CONTACT_NO", nullable = false)
    private String contactNo;

    @JsonIgnore
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    @Column(name = "CREATED_DATE", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonIgnore
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    @Column(name = "STATUS", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean status;


    public Student(String name, Date dob, String address, String contactNo) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.contactNo = contactNo;
    }

    public Student(Long id, String name, Date dob, String address, String contactNo) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.contactNo = contactNo;
    }
}