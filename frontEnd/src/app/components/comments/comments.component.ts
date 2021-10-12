import { Component, OnInit } from '@angular/core';
import { Comment } from '../../service/comments/comment';
import { CommentsService } from '../../service/comments/comments.service';

@Component({
	selector: 'app-comments',
	templateUrl: './comments.component.html',
	styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
	comments: Comment[] = [];

	constructor(private commentService: CommentsService) { }

	ngOnInit(): void {
		this.getAllComments();
	}

	getAllComments(): void {
		this.commentService.getAllComments()
			.subscribe(
				comment => {
					this.comments = comment;
				},
				error => {
					console.error("CommentsComponent Error handler was invoked: ", error);
				}
			);
	}
}
