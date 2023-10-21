package com.sud.asimov;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class File(
    @Id
    public var name: String,
    @Lob
    public var content : ByteArray) {
}