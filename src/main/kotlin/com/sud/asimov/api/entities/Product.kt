package com.sud.asimov;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
class Product (
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  var name: String,
  @ManyToOne
  var category: Category,
  var price: Float,
  var description: String?,
  var stock: Int,
  var reference: String,
  @OneToOne
  var image: File?,
) {
}


// class ProductEntry {
//   id: number;
//   name: string;
//   category: string;
//   description: string;
//   price: number;
//   stock: number;
//   reference: string;
//   image: string;

//   constructor(
//     id: number,
//     name: string,
//     category: string,
//     description: string,
//     price: number,
//     stock: number,
//     reference: string,
//     image: string,
//   ) {
//     this.id = id;
//     this.name = name;
//     this.category = category;
//     this.description = description;
//     this.price = price;
//     this.stock = stock;
//     this.reference = reference;
//     this.image = image;
//   }
// }

