import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';
import { Book } from 'src/app/model/book';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  id:string;
  title:string;
  desc:string;
  author:string;
  price:number;


  book:any=[];
  constructor(private bookService:BookService) { }

  ngOnInit() {
    this.bookService.getAllBook().subscribe((response)=>{
      if(response && response.length>0)
      {
        this.book=response;
      }

  });
  }


  checkout(book){
    //   const book=new Book(this.id,this.title,this.desc,this.author,this.price);
       this.bookService.addBookCart(book).subscribe((response)=>{
         console.log(response);
       });
     }



}
