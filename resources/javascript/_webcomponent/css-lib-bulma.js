import { LitElement, html } from 'lit-element';

class CssLibBulma extends LitElement {
  render() {
    return html`
      <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.css"
      />
    `;
  }
}

customElements.define('css-lib-bulma', CssLibBulma);
