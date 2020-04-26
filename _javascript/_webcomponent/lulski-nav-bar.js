// Import the LitElement base class and html helper function
import { LitElement, html } from 'lit-element';
import './css-lib-bulma.js'
// Extend the LitElement base class
class LulskiNavBar extends LitElement {

  static get properties() {
    return {
      navbar_burger_style: { type: String },
      navbar_menu_style: { type: String },
      navbar_state_expanded: { type: Boolean }
    }
  }

  constructor() {
    super();

    this.navbar_burger_style = "navbar-burger";
    this.navbar_menu_style = "navbar-menu";
    this.navbar_state_expanded = false;
  }

  _onBurgerClick() {

    // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"

    if (this.navbar_state_expanded === false) {
      this.navbar_burger_style = "navbar-burger is-active";
      this.navbar_menu_style = ("navbar-menu is-active");
      this.navbar_state_expanded = true;
    } else {
      this.navbar_burger_style = "navbar-burger";
      this.navbar_menu_style = ("navbar-menu");
      this.navbar_state_expanded = false;
    }
  }


  render() {

    return html`

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.css">   


      <nav class="navbar" role="navigation" aria-label="main navigation">
          <div class="navbar-brand">
            <a class="navbar-item" href="#">lulski website</a>
            <a role="button" class=${this.navbar_burger_style} aria-label="menu" aria-expanded="false" data-target="navbarBasicExample" @click=${this._onBurgerClick}>
              <span aria-hidden="true"></span>
              <span aria-hidden="true"></span>
              <span aria-hidden="true"></span>
            </a>
          </div>
      
          <div id="navbarBasicExample" class=${this.navbar_menu_style}>
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