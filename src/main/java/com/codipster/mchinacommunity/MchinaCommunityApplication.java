package com.codipster.mchinacommunity;

import com.codipster.mchinacommunity.enums.Roles;
import com.codipster.mchinacommunity.mongodocs.*;
import com.codipster.mchinacommunity.mongodocs.embedded.post.Image;
import com.codipster.mchinacommunity.mongodocs.embedded.post.Link;
import com.codipster.mchinacommunity.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class MchinaCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MchinaCommunityApplication.class, args);
	}

	// initialize the database with some test data / command line runner
	@Bean
	public CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository, LikeRepository likeRepository, CommentRepository commentRepository, PostRepository postRepository) {
		return (args) -> {
			// add some test data
			User user1 = User.builder().username("user1").password("password").email("user1@gmail.com").role(Roles.USER).build();
			User user2 = User.builder().username("user2").password("password").email("user2@gmail.com").role(Roles.USER).build();
			userRepository.saveAll(List.of(user1, user2));
			// add posts with attributes everything (title, content, user, images, links, hashtags)
			// get user
			User user11 = userRepository.findByUsername("user1").orElse(null);
			User user22 = userRepository.findByUsername("user2").orElse(null);
			// create images and links
			Image image1 = Image.builder().imagePath("https://www.google.com").imageId(UUID.randomUUID().toString()).imageDescription("image desc").build();
			Image image2 = Image.builder().imagePath("https://www.facebook.com").imageId(UUID.randomUUID().toString()).imageDescription("image desc").build();
			Image image3 = Image.builder().imagePath("https://www.instagram.com").imageId(UUID.randomUUID().toString()).imageDescription("image desc").build();
			Image image4 = Image.builder().imagePath("https://www.twitter.com").imageId(UUID.randomUUID().toString()).imageDescription("image desc").build();
			// create links
			Link link1 = Link.builder().url("https://www.google.com").linkId(UUID.randomUUID().toString()).placeholder("link 1").build();
			Link link2 = Link.builder().url("https://www.facebook.com").linkId(UUID.randomUUID().toString()).placeholder("link 2").build();
			Link link3 = Link.builder().url("https://www.instagram.com").linkId(UUID.randomUUID().toString()).placeholder("link 3").build();
			Link link4 = Link.builder().url("https://www.twitter.com").linkId(UUID.randomUUID().toString()).placeholder("link 4").build();
			// create posts
			Post post1 = Post.builder().title("First Post").textContent("This is the first post").hashtags(List.of("first", "post")).images(List.of(image1, image2)).links(List.of(link1, link2)).user(user11).build();
			Post post2 = Post.builder().title("Second Post").textContent("This is the second post").hashtags(List.of("second", "post")).images(List.of(image3, image4)).links(List.of(link3, link4)).user(user22).build();
			postRepository.saveAll(List.of(post1, post2));
			// add comments with attributes everything (content, user, post)
			// get posts
			Post post11 = postRepository.findByTitle("First Post").orElse(null);
			Post post22 = postRepository.findByTitle("Second Post").orElse(null);
			// create comments
			Comment comment1 = Comment.builder().text("This is the first comment").parentComment(null).user(user22).post(post11).build();
			Comment comment2 = Comment.builder().text("This is the second comment").parentComment(null).user(user11).post(post22).build();
			commentRepository.saveAll(List.of(comment1, comment2));
			// get comments
			Comment comment11 = commentRepository.findByText("This is the first comment").orElse(null);
			Comment comment22 = commentRepository.findByText("This is the second comment").orElse(null);
			// create replies
			Comment reply1 = Comment.builder().text("This is the first reply").parentComment(comment11).user(user11).post(post11).build();
			Comment reply2 = Comment.builder().text("This is the second reply").parentComment(comment22).user(user22).post(post22).build();
			commentRepository.saveAll(List.of(reply1, reply2));
			// add likes with attributes everything (user, post)
			// create likes
			Like like1 = Like.customLikeBuilder(user11,post22);
			Like like2 = Like.customLikeBuilder(user22,post11);
			Like like3 = Like.customLikeBuilder(user11,comment11);
			Like like4 = Like.customLikeBuilder(user22,comment22);
			Like like5 = Like.customLikeBuilder(user11,comment22);
			Like like6 = Like.customLikeBuilder(user22,comment11);
			likeRepository.saveAll(List.of(like1,like2,like3,like4,like5,like6));

		};
	}


}
