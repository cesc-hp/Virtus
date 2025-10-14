import gql from "graphql-tag";

export const newModule = gql`
  mutation newModule($title: String!, $idImg: ID!, $courseId: ID!) {
    newModule(title: $title, idImg: $idImg, courseId: $courseId) {
      id
      title
      img {
        url
      }
    }
  }
`;

export const updateModule = gql`
  mutation updateModule($id: ID!, $title: String!, $idImg: ID!) {
    updateModule(id: $id, title: $title, idImg: $idImg) {
      title
      img {
        id
        url
      }
    }
  }
`;

export const deleteModule = gql`
  mutation deleteModule($id: ID!) {
    deleteModule(id: $id)
  }
`;

// ---- Mutation for state local ----
export const checkModuleMutation = gql`
  mutation checkModuleMutation($id: ID!, $title: String!, $imgUrl: String!) {
    checkCursoMutation(id: $id, title: $title, imgUrl: $imgUrl) @client {
      id
      title
      imgUrl
    }
  }
`;
