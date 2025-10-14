import gql from "graphql-tag";

export const getAllCourse = gql`
  query {
    getAllCourse {
      id
      name
      description
      img {
        id
        url
      }
    }
  }
`;

export const modsByCourId = gql`
  query courseById($id: ID!) {
    courseById(id: $id) {
      name
      modules {
        id
        title
        img {
          id
          url
        }
      }
    }
  }
`;
