Programs used:

- Intellij IDEA - https://www.jetbrains.com/idea/
- Chrome Driver - https://chromedriver.chromium.org/downloads
- Firefox Driver – https://github.com/mozilla/geckodriver/releases

The test cases:

- SearchTest – searching for a game with a specific keyword, the test starts by finding the search bar, enters the text to be searched and then it checks if the first element that comes up in search results has the word we searched for

- GamePlayTest – checking if the first game on the website actually works, the test starts by finding the first game displayed on the website, clicks on the game and checks if the game is displayed on the screen or not

- CrossBrowserTest - checking browser compatibility with the use of a testng file, the test starts by choosing the browser and it additionally checks if the input for the login is case sensitive

- LoginTest – checking if the login data is correct (for the purpose of the test an account was made), the test starts by finding the button for login, next it finds the element for username input and sends the username and it repeats the same action for the password, with the click of the submit button it logs in and checks the title (if the login is successfull we go to page for favorite games)

- NavigationTest – checking if the navigation bar leads to the right websites, there are two tests within this test – one to check if the Puzzle button goes to the Puzzle page and the other to check if the Sudoku button goes to the Sudoku page


To run the test press ctrl+shift+f10 on keyboard or right click on the test class you want to run and click on Run 'Test_Name' (i.e. Run ' GamePlayTest '). The CrossBrowserTest is run by running the testng.xml file or from the command line with 'mvn test' command.
