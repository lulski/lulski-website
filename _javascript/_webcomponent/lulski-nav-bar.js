// Import the LitElement base class and html helper function
import { LitElement, html } from 'lit-element';
import './css-lib-bulma.js'
// Extend the LitElement base class
class LulskiNavBar extends LitElement {

  /**
   * Implement `render` to define a template for your element.
   *
   * You must provide an implementation of `render` for any element
   * that uses LitElement as a base class.
   */
  render() {
    /**
     * `render` must return a lit-html `TemplateResult`.
     *
     * To create a `TemplateResult`, tag a JavaScript template literal
     * with the `html` helper function:
     */
    return html`

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.css">   


      <nav class="navbar" role="navigation" aria-label="main navigation">
      <div class="navbar-brand">
        <a class="navbar-item" href="#">lulski website</a>
        <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
        </a>
      </div>
  
      <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
          <a class="navbar-item">navbar menu 1 (home)</a>
  
          <div class="navbar-item has-dropdown is-hoverable">
            <a class="navbar-link">navbar menu 2 dropdown</a>
            <div class="navbar-dropdown">
              <a class="navbar-item">dropdown1 item</a>
              <a class="navbar-item">dropdown2 item</a>
            </div>
          </div>
  
        </div>
  
        <div class="navbar-end">
          <div class="navbar-item">
            <a class="button is-primary">Log in</a>
  
          </div>
        </div>
  
      </div>
  
    </nav>
    `;
  }
}
// Register the new element with the browser.
customElements.define('lulski-nav-bar', LulskiNavBar);