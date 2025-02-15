To download .exe file click on it

https://drive.google.com/file/d/1sv7te-rjPH0pKlYqHwXi5sLewlazd_zq/view?usp=drive_link



Problem Statement - Quiz on different fields


(i)	First Frame(Intro Fame): Number of buttons-2, i.e., start and quit.
Start: The user enters the log in page/frame. This frame is used to register the user or to let the user log in oneself. 
	Log in : The user has to enter two fields in this frame to log in oneself. This is done with the help of a pre-created file which stores the data of all the registered users in a particular format. 
	Sign up : The user has to enter four fields in this frame to sign up one self. If the user provides exactly the same data  as an already registered user then, the program informs the user that they have been already been registered, lest in the case if the user is new, then the provided data gets saved in the user-data file. 
	
If we either sign up or log in, the introduction frame is visible which tells the user about how to play the quiz and also about the different fields on which the quiz can be taken by the user. 

After the introduction frame, the option of different fields of the quiz is given to the user. The user can select the field on which S/he wants to attempt the quiz.

Once a field has been chosen by the user, the question frame gets displayed. 
Working: There are different text files made for each of the fields which comprises of the questions pertaining to that field. When the user chooses a field, the data of that particular field gets opened/ accessed and then, the number of lines in that particular field gets counted. Each quiz of any field includes a total of 10 questions in it. 10 random numbers(stored in an array) are generated to index 10 random questions of the question file and stored in a set type field to avoid duplicity of numbers and hence, the duplicity of questions in a particular quiz. 

	Question Examples stored in the file(Format): 
1.Maximum number of teeth an adult have?32
2.Who is the founder of facebook?MarkZuckerberg

In the format, every line initiates with the question number then, a period(.) followed by the question, then the question mark (?) followed by the answer.   	
In this way, in accordance with these 10 indexes, 10 questions are extracted from the question file. And stored in the array of question and answer will stored in answer’s array

This page consists five buttons:
•	Next
•	Back
•	Submit
•	Final Submission
•	Quit

	Next: Next button is used for skip the question or change the question. For instance if user submit the answer then he/she has to click on Next button so that next question will appear on screen.
	Back: Back button is used for come back to the previous question so that if user click next button two time or by mistake he/she skip question he/she can came to previous question and can attempt it. This button will enable only when the user skip a question if user submit the question and then try to use back button then it will not work.
	Submit: Submit button is used for submit the answer entered by user and after pressing this button user will able to check whether his/her answer is right or wrong if the answer is wrong then the correct answer will displayed.
	Quit: Quit button is used to leavethe quiz. If user didn’t want to complete quiz then he/she can leave it in between without completing quiz.
	Final Submission: This button will enabled only when user attempts all the question. 

In second example if user enters wrong name or spelling then the answer is counted as incorrect, for example he/she enters Mark Zukerberg then here spelling of Zuckerberg is wrong which leads to the answer is counted as wrong answer.

Once the user clicked on quit or final submission button the question frame gets invisible and scoreboard frame gets displayed in which total number of question that user attempted, how many from that are correct and how many are wrong will displayed.

Apart from that Scoreboard frame consists of two buttons one is for play again and other one is quit.

Play again button displayed the buttons frame will displayed from which user can select any of the field again and same procedure will repeated as discussed above.

Quit button will terminates the program


Quit: Terminates the entire program.



