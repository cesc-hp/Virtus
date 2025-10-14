import gql from "graphql-tag";

export const newCourse = gql`
  mutation newCourse($name: String!, $description: String!, $idImg: ID!) {
    newCourse(name: $name, description: $description, idImg: $idImg) {
      id
      name
      description
      img {
        url
      }
    }
  }
`;
export const updateCourse = gql`
  mutation updateCourse(
    $id: ID!
    $name: String!
    $description: String!
    $idImg: ID!
  ) {
    updateCourse(
      id: $id
      name: $name
      description: $description
      idImg: $idImg
    ) {
      name
      description
      img {
        id
        url
      }
    }
  }
`;
export const deleteCourse = gql`
  mutation deleteCourse($id: ID!) {
    deleteCourse(id: $id)
  }
`;

// ---- Mutation for state local ----
export const checkCursoMutation = gql`
  mutation checkCursoMutation($id: ID!, $name: String!, $description: String!) {
    checkCursoMutation(id: $id, name: $name, description: $description) @client
  }
`;
