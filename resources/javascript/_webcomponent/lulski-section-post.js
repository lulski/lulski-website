import { LitElement, html } from 'lit-element';

class LulskiSectionPost extends LitElement {
  static get properties() {
    return {
      post: { type: String },
      title: { type: String },
      stateExpanded: { type: Boolean },
      tags: { type: Array },
    };
  }

  render() {
    return html`
      <link
        rel="stylesheet"
        href="resources/css/bulma-0.9.0/css/bulma.min.css"
      />

      <div class="container mb-2">
        <div class="box">
          <div class="content is-medium">
            <h3>${this.title}</h3>
            <p>${this.post}</p>
          </div>
        </div>
      </div>
    `;
  }
}

customElements.define('lulski-section-post', LulskiSectionPost);
