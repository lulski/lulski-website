// Import the LitElement base class and html helper function
import { LitElement, html } from 'lit-element';

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
      this.navbarBurgerSyle = 'navbar-burger is-dark is-active';
      this.navbarMenuStyle = 'navbar-menu is-dark is-active';
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
        href="resources/css/bulma-0.9.0/css/bulma.min.css"
      />

      <nav
        class="navbar is-dark"
        role="navigation"
        aria-label="main navigation"
      >
        <div class="navbar-brand">
          <a class="navbar-item" href="#">Lulski</a>
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

        <div id="navbarBasicExample" class="${this.navbarMenuStyle}">
          <div class="navbar-start">
            ${this.navbarItems.map(
              navbarItem => html` <a class="navbar-item">${navbarItem}</a> `
            )}
          </div>

          <div class="navbar-end">
            <div class="navbar-item">
              <a class="button is-light">Log in</a>
            </div>
          </div>
        </div>
      </nav>
    `;
  }
}
// Register the new element with the browser.
customElements.define('lulski-nav-bar', LulskiNavBar);
