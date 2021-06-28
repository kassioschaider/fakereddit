import { TimelinePage } from './timeline.po';
import { browser, element, by, protractor } from 'protractor';

describe('Timeline Page', () => {

  let timelinePage: TimelinePage;

  beforeEach(async () => {
    timelinePage = new TimelinePage();
    await timelinePage.navigateTo();
  });

  it('Should navigate to page Timeline', async () => {
    const titlePage = await timelinePage.getWindowTitle();
    expect(titlePage).toEqual('Fakereddit');
  });

  it('Should display message Empty timeline!', async () => {
    expect(await timelinePage
      .getTextByCss('.empty-posts'))
      .toEqual('Empty timeline!');
  });

  it('Should navigate to page New Post', async () => {
    await browser.get(`${browser.baseUrl}/new-publish`);

    expect(await timelinePage.getTextByCss('.form-post__title')).toEqual('New Post');
  });

  it('Should create a new Post', async () => {
    await browser.get(`${browser.baseUrl}/new-publish`);

    await timelinePage.fillInputWithTextByCss(
      '.form-field__input',
      'There are many variations of passages of Lorem Ipsum available.'
    );
    await timelinePage.clickButtonByCss('.button-publish');

    expect(await timelinePage.getTextByCss('.title')).toEqual('Timeline');
  });

  it('Should display a list of Posts', async () => {
    const postListSize = await timelinePage.getPostListSize();
    expect(postListSize).toBeGreaterThan(0);
  });

  it('Should get first element of list and check content', async () => {
    expect(await timelinePage.getTextByCss('.timeline__content__content'))
      .toEqual('There are many variations of passages of Lorem Ipsum available.');
  });

  it('Should upvotes to first post', async () => {
    const firstElement =
      timelinePage
        .getAllElementsByCss('.timeline__votes__icon')
        .first();
    await firstElement.click();

    const firstElementVotes =
      timelinePage
        .getAllElementsByCss('.timeline__votes__upvotes')
        .first();

    expect(await firstElementVotes.getText()).toBe('Votes 1');
  });

});
