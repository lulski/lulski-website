import React from "react";
import { Container } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";

const BasicExample = () => {
  return (
    <>
      <style type="text/css">
        {`
          .btn-flat {
            background-color: purple;
            color: white;
          }
          
          .btn-flat:hover {
            background-color: red
            ;
            color: white;
          }

          .btn-xxl {
            padding: 1rem 1.5rem;
            font-size: 1.5rem;
          }
    `}
      </style>

      <Container fluid="md">
        <Form>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control type="email" placeholder="Enter email" />
            <Form.Text className="text-muted">
              your email address is your login ID.
            </Form.Text>
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control type="password" placeholder="Password" />
          </Form.Group>

          <Button type="submit" variant="flat" size="xxl">
            Submit
          </Button>
        </Form>
      </Container>
    </>
  );
};

export default BasicExample;
