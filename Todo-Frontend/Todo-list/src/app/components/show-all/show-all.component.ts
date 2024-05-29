import { Component,OnInit } from '@angular/core';
import { Todo } from 'src/app/model/todo';
import { HttpTodoService } from 'src/app/services/http-todo.service';


@Component({
  selector: 'app-show-all',
  templateUrl: './show-all.component.html',
  styleUrls: ['./show-all.component.css']
})
export class ShowAllComponent {

    listOfTodos : Todo [] =[];
  constructor(private todoService:HttpTodoService) { }

   ngOnInit() :void {
    this.todoService.findAll().subscribe( (todo:any)=>
    {
      this.listOfTodos = todo;
    }
    );
   }



}
