from selenium import webdriver
from selenium.webdriver.common.by import By
import pandas as pd

class NewsScrapper:
    def __init__(self):
        self.driver = webdriver.Chrome()
        self.data = []
    
    def scrape_headlines(self):
        self.driver.get('https://www.bbc.news')
        headline_elements = self.driver.find_elements(By.CSS_SELECTOR, 'h2')
        body_elements = self.driver.find_elements(By.CSS_SELECTOR, 'p')

        print("Latest BBC News Headlines:")
        for idx, (headline, body) in enumerate(zip(headline_elements, body_elements), 1):
            self.data.append({'Headline': headline.text, 'Body': body.text})

    def close(self):
        self.driver.quit()

    def create_dataframe(self):
        df = pd.DataFrame(self.data)
        df.to_csv('news.csv', index=False)

# Main function to run the scrapper
def main():
    scrapper = NewsScrapper()
    scrapper.scrape_headlines()
    df = scrapper.create_dataframe()
    print(df)
    scrapper.close()

if __name__ == "__main__":
    main()