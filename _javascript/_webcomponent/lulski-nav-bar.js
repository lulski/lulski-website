// Import the LitElement base class and html helper function
import { LitElement, html } from 'lit-element';

import './css-lib-bulma.js';
// Extend the LitElement base class
class LulskiNavBar extends LitElement {
  static get properties() {
    return {
      navbarBurgerSyle: { type: String },
      navbarMenuStyle: { type: String },
      navbarStateExpanded: { type: Boolean },
      navbarItems: { type: Array },
    };
  }

  constructor() {
    super();

    this.navbarBurgerSyle = 'navbar-burger';
    this.navbarMenuStyle = 'navbar-menu';
    this.navbarStateExpanded = false;
  }

  connectedCallback() {
    super.connectedCallback();
    console.log('lit element connected');
  }

  firstUpdated() {
    console.log(this.navbarItems);
  }

  _onBurgerClick() {
    // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"

    if (this.navbarStateExpanded === false) {
      this.navbarBurgerSyle = 'navbar-burger is-active';
      this.navbarMenuStyle = 'navbar-menu is-active';
      this.navbarStateExpanded = true;
    } else {
      this.navbarBurgerSyle = 'navbar-burger';
      this.navbarMenuStyle = 'navbar-menu';
      this.navbarStateExpanded = false;
    }
  }

  render() {
    return html`
      <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.css"
      />

      <nav class="navbar" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
          <a class="navbar-item" href="#">lulski website</a>
          <a
            role="button"
            class=${this.navbarBurgerSyle}
            aria-label="menu"
            aria-expanded="false"
            data-target="navbarBasicExample"
            @click=${this._onBurgerClick}
          >
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>

        <div id="navbarBasicExample" class=${this.navbarMenuStyle}>
          <div class="navbar-start">
            ${this.navbarItems.map(
              navbarItem => html` <a class="navbar-item">${navbarItem}</a> `
            )}
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
