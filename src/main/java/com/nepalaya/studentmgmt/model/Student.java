package com.nepalaya.studentmgmt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
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
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @Size(min = 2, max=150)

    private String name;
    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name="DOB")
    private Date dob;

    @NotBlank
    @Column(name="ADDRESS")
    @Size(min = 2, max=200)
    private String address;

    @NotBlank
    @Column(name="CONTACT_NO")
    private String contactNo;

    @Column(name="CREATED_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ColumnDefault(value="TRUE")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    @Column(name="STATUS", columnDefinition = "BOOLEAN DEFAULT TRUE")
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