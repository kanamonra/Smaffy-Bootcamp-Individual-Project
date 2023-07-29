package com.ceceg.smaffy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsersData {
    @Id
    private ObjectId id;
    private String userid;
    private String pw;
    private String company;

    public UsersData(String userid, String pw, String company){
        this.userid = userid;
        this.pw= pw;
        this.company=company;
    }
}
