import "bulma/css/bulma.min.css";
import { Link } from "react-router-dom";

const Homepage = () => {
  // Component logic
  return (
    <div class="container full-viewport">
      <div class="columns is-vcentered">
        <div class="column is-7 is-vcentered">
          <div class="box">
            <section class="hero">
              <div class="hero-body">
                <p class="title">Click the dune</p>
                <p>
                  This space gives you more room to expound on your message.
                  Remember that writing effectively is an art. Start by using
                  simple, everyday words people can easily understand. Be clear
                  and direct to the point. Keep your thoughts flowing logically,
                  and aim for brevity. Your ideas have a purpose, so choose
                  words that accurately express them. Ensure your grammar is
                  flawless as it impacts your credibility. Use the active voice
                  whenever possible as it makes any narrative easier to read.
                </p>
              </div>
            </section>
          </div>
        </div>
        <div class="column is-vcentered">
          <figure class="image is-x256">
            <Link to="/create">
              <img src="/dune.jpg" />
            </Link>
          </figure>
        </div>
      </div>
    </div>
  );
};

export default Homepage;
