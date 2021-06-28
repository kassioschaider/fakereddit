import { browser, by, element } from 'protractor';

export class TimelinePage {
  navigateTo() {
    return browser.get(`${browser.baseUrl}/timeline`);
  }

  getWindowTitle() {
    return browser.getTitle();
  }

  fillInputWithTextByCss(selector: string, text: string) {
    return element(by.css(selector)).sendKeys(text);
  }

  getPostListSize() {
    return element.all(by.css('.timeline__content')).count();
  }

  clickButtonByCss(selector: string) {
    return element(by.css(selector)).click();
  }

  getTextByCss(selector: string) {
    return element(by.css(selector)).getText();
  }

  getAllElementsByCss(selector: string) {
    return element.all(by.css(selector));
  }
}
