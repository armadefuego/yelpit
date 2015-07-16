package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Reviews(reviewID: Long, userID: Long, review: String)

object Reviews {
  
  // -- Parsers
  
  /**
   * Parse a Reviews from a ResultSet
   */
  val simple = {
    get[Long]("review.reviewID") ~
    get[Long]("review.userID") ~
    get[String]("review.review") map {
      case reviewID~userID~review => Reviews(reviewID, userID, review)
    }
  }
  
  // -- Queries
  
  /**
   * Retrieve a Reviews from user.
   */
  def findByUser(userID: Long): Option[Reviews] = {
    None
  }
   
  /**
   * Create a Reviews.
   */
  def create(review: Reviews): Reviews = {
      DB.withConnection { implicit connection =>
      SQL(
        """
          insert into review values (
            {userID}, {review}
          )
        """
      ).on(
        'userID -> review.userID,
        'review -> review.review
       ).executeUpdate()
      
      review
      
    }
  }
  
}
 