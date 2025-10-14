import gql from "graphql-tag";

export const getAllModules = gql`
  query {
    getAllModules {
      id
      title
      img {
        id
        url
      }
    }
  }
`;

export const lessByModId = gql`
  query moduleById($id: ID!) {
    moduleById(id: $id) {
      course {
        name
      }
      title
      lessons {
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

// --- Query local state ---
export const editModule = gql`
  query editModule @client {
    id
    title
    imgUrl
  }
`;
