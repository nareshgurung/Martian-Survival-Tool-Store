import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Comment } from '../../models/comment';
import { CommentsService } from '../../service/comments/comments.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
	selector: 'app-comments',
	templateUrl: './comments.component.html',
	styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit,OnChanges {
	@Input() productID = -1;
	comments: Comment[] = [];
	commentBox:boolean = false;
	commentButton:boolean = false;
	newComment:string = "";

	constructor(private commentService: CommentsService, private router:Router, private aRout:ActivatedRoute) { }

	ngOnInit(): void {
	}

	ngOnChanges(change: SimpleChanges): void{
		this.getAllComments();
	}

	getAllComments(): void {
		this.commentService.getCommentsForProduct(this.productID).subscribe(comment => this.comments = comment);
		if(NavbarComponent.userInfo.user_id > 0){
			this.commentButton=true;
		}
	}

	showBox(){
		if(this.commentBox) {
			this.commentBox = false;
		} else {
			this.commentBox = true;
		}
	}

	submitButton():void {
		let comms:Comment = {
			comment_id: -1,
			product_id: this.productID,
			user_id: NavbarComponent.userInfo.user_id,
			comment: this.newComment
		};
		var tf;
		this.commentService.setNewComment(comms).subscribe(trueFalse=> tf = trueFalse);
		let currentURL = this.router.url;
		this.router.navigateByUrl('/error').then(
			() => this.router.navigateByUrl(currentURL)
		);
	}
	
}
