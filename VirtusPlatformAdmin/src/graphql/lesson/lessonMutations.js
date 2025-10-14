import gql from "graphql-tag";

export const newLesson = gql`
  mutation newLesson($title: String!, $idImg: ID!, $moduleId: ID!) {
    newLesson(title: $title, idImg: $idImg, moduleId: $moduleId) {
      id
      title
      img {
        url
      }
    }
  }
`;

export const updateLesson = gql`
  mutation updateLesson($id: ID!, $title: String!, $idImg: ID!) {
    updateLesson(id: $id, title: $title, idImg: $idImg) {
      title
      img {
        id
        url
      }
    }
  }
`;

export const deleteLesson = gql`
  mutation deleteLesson($id: ID!) {
    deleteLesson(id: $id)
  }
`;

// ---- Mutation for state local ----
export const checkLessonMutation = gql`
  mutation checkLessonMutation($id: ID!, $title: String!, $imgUrl: String!) {
    checkLessonMutation(id: $id, title: $title, imgUrl: $imgUrl) @client {
      id
      title
      imgUrl
    }
  }
`;
